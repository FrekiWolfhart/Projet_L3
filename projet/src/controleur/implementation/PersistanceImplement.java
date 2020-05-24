package controleur.implementation;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import controleur.PersistanceServiceEcriture;
import modele.Adherent;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.Pret;
import modele.Reservation;
import modele.primaryKeys.ExemplairePK;
import modele.primaryKeys.ReservationPK;

public class PersistanceImplement implements PersistanceServiceEcriture {

	private final SessionFactory sessionFactory;

	public PersistanceImplement() {
		Configuration config = new Configuration();

		config.addPackage("modele").addPackage("modele.primaryKeys");

		config.addAnnotatedClass(ExemplairePK.class).addAnnotatedClass(ReservationPK.class).addAnnotatedClass(Adherent.class)
				.addAnnotatedClass(Exemplaire.class).addAnnotatedClass(Oeuvre.class).addAnnotatedClass(Pret.class).addAnnotatedClass(Reservation.class);

		config.configure(); // TODO

		this.sessionFactory = config.buildSessionFactory();
	}

	private Session newSession() {
		return sessionFactory.openSession();
	}

	@Override
	public Collection<Adherent> getAdherents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<String> getAuteurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Exemplaire> getExemplaires() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exemplaire getExemplaire(String cote, int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Oeuvre> getOeuvres() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Pret> getPrets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pret getPret(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Pret> getPretsEnRetard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Reservation> getReservations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adherent getAdherent(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Adherent> getAdherents(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Oeuvre> getAuteur(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Oeuvre getOeuvre(String cote) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Oeuvre> getOeuvres(String titre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<String> getTags() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Oeuvre> getTag(String tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enregistrer(Adherent adherent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mettreAJour(Adherent adherent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enregistrer(Exemplaire exemplaire) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enregistrer(Oeuvre oeuvre) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enregistrer(Pret pret) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mettreAJour(Pret pret) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enregistrer(Reservation reservation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimer(Reservation reservation) {
		// TODO Auto-generated method stub

	}

}