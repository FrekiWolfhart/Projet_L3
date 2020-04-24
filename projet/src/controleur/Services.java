package controleur;

import java.time.temporal.Temporal;

import modele.Adherent;
import modele.Auteur;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.Pret;

public interface Services {

	public Adherent ajouterAdherent(String nom, String email);

	public Pret emprunter(int idAdherent, String coteOeuvre, int numeroExemplaire);
	
	public Pret emprunter(Adherent adherent, Exemplaire exemplaire);
	
	public Pret emprunter(int idAdherent, String coteOeuvre);

	public Pret emprunter(Adherent adherent, Oeuvre oeuvre);

	public boolean prolonger(String coteOeuvre, int numeroExemplaire, int idEmprunteur, String dateEmprunt);
	
	public boolean prolonger(String coteOeuvre, int numeroExemplaire, int idEmprunteur, Temporal dateEmprunt);
	
	public boolean prolonger(Pret pret);
	
	public void reserver(int idAdherent, String coteOeuvre);
	
	public void reserver(Adherent adherent, Oeuvre oeuvre);

	public void envoyerEmailRetardataires();

	public void envoyerEmailRetardataire(Adherent adherent);

	public void envoyerEmail(Adherent adherent, String contenu);

	public void payerCotisation(int idAdherent);
	
	public void payerCotisation(Adherent adherent);

	public void rendreLivre(Pret pret);
	
	public Exemplaire ajouterExemplaire(String coteOeuvre);

	public Exemplaire ajouterExemplaire(Oeuvre oeuvre);
	
	public Oeuvre ajouterLivre(String auteur, String titre, String dateSortie);
	
	public Oeuvre ajouterLivre(String auteur, String titre, Temporal dateSortie);

	public Oeuvre ajouterLivre(Auteur auteur, String titre, Temporal dateSortie);
}