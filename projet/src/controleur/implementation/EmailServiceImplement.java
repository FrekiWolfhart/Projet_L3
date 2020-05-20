package controleur.implementation;

import java.util.Collection;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import controleur.DureePretService;
import controleur.EmailService;
import controleur.PersistanceServiceLecture;
import modele.Adherent;
import modele.Pret;

public class EmailServiceImplement implements EmailService {

	@Autowired
	private PersistanceServiceLecture persistance;
	@Autowired
	private DureePretService dureePret;

	@Override
	public void envoyerEmailRetardataires() {
		// TODO
	}

	@Override
	public void envoyerEmailRetardataire(Adherent adherent, Collection<Pret> pretsEnRetard) {
		if (pretsEnRetard != null) {
			String email = "Cher(e) " + adherent.getNom() + " " + adherent.getPrenom()
					+ "\n Nous vous envoyer ce mail car il se trouve que vous avez oublié de nous retourner certains livres empruntés à notre bibliothèque."
					+ "\n Pour rappel, la duréee d'emprunt est de un mois. Voici la liste des livres concernés :";
			for (Pret pret : pretsEnRetard) {
				email += "\n - " + pret.getExemplaire();
			}
			email += "\n Merci de retourner au plus vite ces livres" + "\n Cordialement" + "\n Bibliothèque de l'université Aix-Marseille";
			envoyerEmail(adherent, email);

		}
	}

	@Override
	public void envoyerEmail(Adherent adherent, String contenu) {
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.port", "456");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		Session session = Session.getInstance(properties);

		MimeMessage message = new MimeMessage(session);
		try {
			message.setText(contenu);
			message.setSubject("Retard");
			message.setRecipients(Message.RecipientType.TO, adherent.getEmail());
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		Transport transport = null;
		try {
			transport = session.getTransport("smtp");
			transport.sendMessage(message, new Address[] { new InternetAddress(adherent.getEmail()) });
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
			try {
				if (transport != null) {
					transport.close();
				}
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}
}