package controleur;

import java.util.Collection;

import modele.Adherent;
import modele.Auteur;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.Pret;
import modele.Reservation;

public interface HibernateService {

	public void enregistrer(Adherent adherent);

	public void mettreAJour(Adherent adherent);

	public void enregistrer(Auteur auteur);

	public void enregistrer(Exemplaire exemplaire);

	public void enregistrer(Oeuvre oeuvre);

	public void enregistrer(Pret pret);

	public void mettreAJour(Pret pret);

	public void enregistrer(Reservation reservation);

	public void supprimer(Reservation reservation);

	public Collection<Adherent> getAdherents();

	public Collection<Auteur> getAuteurs();

	public Collection<Exemplaire> getExemplaires();

	public Collection<Oeuvre> getOeuvres();

	public Collection<Pret> getPrets();

	public Collection<Reservation> getReservations();

	public Adherent getAdherent(int numero);

	public Collection<Adherent> getAdherents(String email);

	public Auteur getAuteur(String nom);

	public Oeuvre getOeuvre(String cote);

	public Collection<Oeuvre> getOeuvres(String titre);
}