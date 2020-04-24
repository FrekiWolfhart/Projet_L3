package controleur;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;

import org.springframework.beans.factory.annotation.Autowired;

import modele.Adherent;
import modele.Auteur;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.Pret;

public class ServicesImpl implements Services {

	@Autowired
	private HibernateService hibernate;

	@Autowired
	private DureePretService dureePretService;

	@Override
	public Adherent ajouterAdherent(String nom, String email) {
		Adherent adherent = new Adherent().setNom(nom).setEmail(email);

		hibernate.enregistrer(adherent);

		return adherent;
	}

	@Override
	public Pret emprunter(Adherent adherent, Exemplaire exemplaire) {
		if (exemplaire.estPreté()) {
//			throw new DejaPreteException(exemplaire, adherent); // TODO
		}
		Pret pret = new Pret(adherent, exemplaire, LocalDateTime.now(), dureePretService.getDuree());

		hibernate.enregistrer(pret);

		adherent.ajouterPretEnCours(pret);
		exemplaire.ajouterhistorique(pret);
		exemplaire.setPretActuel(pret);

		return pret;
	}

	@Override
	public Pret emprunter(Adherent adherent, Oeuvre oeuvre) {
		Exemplaire libre = oeuvre.getExemplaireLibre();

		if (libre == null) {
//			throw new AucunExemplaireLibreException(oeuvre); // TODO
		}

		return emprunter(adherent, libre);
	}

	@Override
	public Pret emprunter(int idAdherent, String coteOeuvre, int numeroExemplaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pret emprunter(int idAdherent, String coteOeuvre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean prolonger(String coteOeuvre, int numeroExemplaire, int idEmprunteur, String dateEmprunt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean prolonger(String coteOeuvre, int numeroExemplaire, int idEmprunteur, Temporal dateEmprunt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean prolonger(Pret pret) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reserver(int idAdherent, String coteOeuvre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reserver(Adherent adherent, Oeuvre oeuvre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void envoyerEmailRetardataires() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void envoyerEmailRetardataire(Adherent adherent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void envoyerEmail(Adherent adherent, String contenu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void payerCotisation(int idAdherent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void payerCotisation(Adherent adherent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rendreLivre(Pret pret) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Exemplaire ajouterExemplaire(String coteOeuvre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exemplaire ajouterExemplaire(Oeuvre oeuvre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Oeuvre ajouterLivre(String auteur, String titre, String dateSortie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Oeuvre ajouterLivre(String auteur, String titre, Temporal dateSortie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Oeuvre ajouterLivre(Auteur auteur, String titre, Temporal dateSortie) {
		// TODO Auto-generated method stub
		return null;
	}
}