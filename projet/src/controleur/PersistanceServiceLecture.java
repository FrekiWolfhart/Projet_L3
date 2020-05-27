package controleur;

import java.util.Collection;

import modele.Adherent;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.Pret;
import modele.Reservation;

public interface PersistanceServiceLecture {

	public Collection<Adherent> getAdherents();

	public Collection<String> getAuteurs();

	public Collection<Exemplaire> getExemplaires();
	
	public Exemplaire getExemplaire(String cote, int numero);
	
	public Collection<Oeuvre> getOeuvres();

	public Collection<Pret> getPrets();
	
	public Pret getPret(int numero);
	
	public Collection<Pret> getPretsEnRetard();

	public Collection<Reservation> getReservations();
	
	public Adherent getAdherent(int numero);

	public Collection<Adherent> getAdherents(String email);

	public Collection<Oeuvre> getAuteur(String nom);

	public Oeuvre getOeuvre(String cote);

	public Collection<Oeuvre> getOeuvres(String titre);
	
	public Collection<String> getTags();
	
	public Collection<Oeuvre> getTag(String tag);
}