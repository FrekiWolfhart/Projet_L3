package controleur.implementation;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import controleur.EmailService;
import controleur.PersistanceServiceLecture;
import modele.Adherent;
import modele.Pret;
import org.springframework.scheduling.annotation.Scheduled;

public class EmailServiceImplement implements EmailService {


	@Autowired
	private PersistanceServiceLecture persistance;

	@Override
	@Scheduled(cron = "0 0 8 * * MON")
	public void envoyerEmailRetardataires() {
		Map<Adherent, List<Pret>> pretsEnRetard = persistance.getPretsEnRetard().stream().collect(Collectors.groupingBy(Pret::getAdherent));
		for (Map.Entry<Adherent, List<Pret>> entry : pretsEnRetard.entrySet()) {
			envoyerEmailRetardataire(entry.getKey(),entry.getValue());
		}
	}

	final String username = "biblio.amu.luminy@gmail.com";
	final String password = "univluminy";

	@Override
	public void envoyerEmailRetardataire(Adherent adherent, Collection<Pret> pretsEnRetard) {
		if (pretsEnRetard != null) {
			String email = "Cher(e) " + adherent.getNom() + " " + adherent.getPrenom()
					+ "\n Nous vous envoyer ce mail car il se trouve que vous avez oublié de nous retourner certains livres empruntés à notre bibliothèque."
					+ "\n Pour rappel, la durée d'emprunt est de un mois. Voici la liste des livres concernés :";
			for (Pret pret : pretsEnRetard) {
				email += "\n - " + pret.getExemplaire().getOeuvre().getTitre()+" , "+pret.getExemplaire().getOeuvre().getAuteurs();
			}
			email += "\n Merci de retourner au plus vite ces livres" + "\n Cordialement" + "\n Bibliothèque de l'université Aix-Marseille";
			envoyerEmail(adherent, email);

		}
	}

	@Override
	public void envoyerEmail(Adherent adherent, String contenu) {
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		MimeMessage message = new MimeMessage(session);
		try {
			message.setText(contenu);
			message.setFrom(new InternetAddress(username));
			message.setSubject("Retard");
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(adherent.getEmail()));

			Transport.send(message);
			System.out.println("Message envoyé!!");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}


		public Map<Adherent, List<Pret>> RecupererListePretEnRetard() {
			Map<Adherent, List<Pret>> map_pret_retardataire = new HashMap<>();
			Collection<Adherent> adherents = persistance.getAdherents();
			for (Adherent adherent : adherents){
				List<Pret> pretsretard = new ArrayList<>();
				for(Pret pret : adherent.getPrets()){
					LocalDate dateemprunt = pret.getDateEmprunt().toLocalDate();
					LocalDate currentdate = LocalDate.now();
					if(Duration.between(dateemprunt, currentdate).toDays() > 30){
						pretsretard.add(pret);
					}
				}
				map_pret_retardataire.put(adherent,pretsretard);
			}
			return map_pret_retardataire;
		}



	public static void main(String[] args) {
		Adherent adherent = new Adherent();
		adherent.setEmail("molina.kevin13010@gmail.com");
		new EmailServiceImplement().envoyerEmail(adherent, "test");
	}
}
