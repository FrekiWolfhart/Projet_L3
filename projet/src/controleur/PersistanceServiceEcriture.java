package controleur;

import modele.Adherent;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.Pret;
import modele.Reservation;

public interface PersistanceServiceEcriture {

	public void enregistrer(Adherent adherent);

	public void mettreAJour(Adherent adherent);

	public void enregistrer(Exemplaire exemplaire);

	public void enregistrer(Oeuvre oeuvre);

	public void enregistrer(Pret pret);

	public void mettreAJour(Pret pret);

	public void enregistrer(Reservation reservation);

	public void supprimer(Reservation reservation);
}