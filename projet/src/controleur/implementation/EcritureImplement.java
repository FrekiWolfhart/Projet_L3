package controleur.implementation;

import org.springframework.stereotype.Component;

import controleur.PersistanceServiceEcriture;
import modele.Adherent;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.Pret;
import modele.Reservation;

@Component("ecriture")
public class EcritureImplement extends AbstractPersistance implements PersistanceServiceEcriture {

	private void save(Object o) {
		executer(session -> session.save(o));
	}

	private void update(Object o) {
		executer(session -> {
			session.update(o);
			return null;
		});
	}

	@Override
	public void enregistrer(Adherent adherent) {
		save(adherent);
	}

	@Override
	public void mettreAJour(Adherent adherent) {
		update(adherent);
	}

	@Override
	public void enregistrer(Exemplaire exemplaire) {
		save(exemplaire);
	}

	@Override
	public void enregistrer(Oeuvre oeuvre) {
		save(oeuvre);
	}

	@Override
	public void enregistrer(Pret pret) {
		save(pret);
	}

	@Override
	public void mettreAJour(Pret pret) {
		update(pret);
	}

	@Override
	public void enregistrer(Reservation reservation) {
		save(reservation);
	}

	@Override
	public void supprimer(Reservation reservation) {
		executer(session -> {
			session.delete(reservation);
			return null;
		});
	}
}