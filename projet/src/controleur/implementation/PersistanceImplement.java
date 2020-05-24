package controleur.implementation;

import java.util.Collection;

import controleur.PersistanceServiceEcriture;
import modele.Adherent;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.Pret;
import modele.Reservation;

public class PersistanceImplement implements PersistanceServiceEcriture {

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