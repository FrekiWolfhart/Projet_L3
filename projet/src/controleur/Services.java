package controleur;

import java.time.temporal.Temporal;

import modele.Adherent;
import modele.Auteur;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.Pret;

public interface Services {
	
	// TODO : faire en ne prenant que ID en argument

	public Adherent ajouterAdherent(String nom, String email);

	public Pret emprunter(Adherent adherent, Exemplaire exemplaire);

	public Pret emprunter(Adherent adherent, Oeuvre oeuvre);

	public boolean prolonger(Pret pret);

	public void reserver(Adherent adherent, Oeuvre oeuvre);

	public void envoyerEmailRetardataires();

	public void envoyerEmailRetardataire(Adherent adherent);

	public void envoyerEmail(Adherent adherent, String contenu);

	public void payerCotisation(Adherent adherent);

	public void rendreLivre(Pret pret);

	public Exemplaire ajouterExemplaire(Oeuvre oeuvre);

	public Oeuvre ajouterLivre(Auteur auteur, String titre, Temporal dateSortie);
}