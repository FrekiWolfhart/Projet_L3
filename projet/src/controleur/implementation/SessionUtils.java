package controleur.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modele.Adherent;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.Pret;
import modele.Reservation;
import modele.primaryKeys.ExemplairePK;
import modele.primaryKeys.ReservationPK;

enum SessionUtils {
	instance;

	private final SessionFactory sessionFactory;

	private SessionUtils() {
		Configuration config = new Configuration();

		config.addPackage("modele").addPackage("modele.primaryKeys");

		config.addAnnotatedClass(ExemplairePK.class).addAnnotatedClass(ReservationPK.class).addAnnotatedClass(Adherent.class)
				.addAnnotatedClass(Exemplaire.class).addAnnotatedClass(Oeuvre.class).addAnnotatedClass(Pret.class).addAnnotatedClass(Reservation.class);
		// TODO : passer par hibernate.cfg.xml pour spécifier les classes annotées

		config.configure("config/hibernate.cfg.xml");

		this.sessionFactory = config.buildSessionFactory();
	}

	Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
