package controleur;

import java.time.temporal.Temporal;

import modele.*;

public interface Services {

	public Adherent ajouterAdherent(int numero, String nom, String email);

	public Pret emprunter(Adherent adherent, Exemplaire exemplaire);

	public Pret emprunter(Adherent adherent, Oeuvre oeuvre);

	public void prolonger(Pret pret);

	public void reserver(Adherent adherent, Oeuvre oeuvre);

	public void envoyerEmailRetardataires();

	public void envoyerEmailRetardataire(Adherent adherent);

	public void envoyerEmail(Adherent adherent, String contenu);

	public void payerCotisation(Adherent adherent);

	public void rendreLivre(Pret pret);

	public Exemplaire ajouterExemplaire(Oeuvre oeuvre);

	public Oeuvre ajouterLivre(Auteur auteur, String titre, Temporal dateSortie);
}