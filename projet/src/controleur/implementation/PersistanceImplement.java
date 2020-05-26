package controleur.implementation;

import java.io.Serializable;
import java.util.Collection;
import java.util.function.Function;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

		config.configure("config/hibernate.cfg.xml");

		this.sessionFactory = config.buildSessionFactory();
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * créer une transaction et effectu un commit à la fin de la transaction
	 * 
	 * @param <E>
	 */
	private <E> E executer(Function<Session, E> fonction) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();

		E result = fonction.apply(session);

		tx.commit();

		return result;
	}

	private <E> E get(Class<E> classe, Serializable id) {
		return executer(session -> session.get(classe, id));
	}

	private <E> Collection<E> getAll(Class<E> classe) {
		return executer(session -> {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<E> query = builder.createQuery(classe);
			Root<E> root = query.from(classe);
			query.select(root);

			return session.createQuery(query).getResultList();
		});
	}

	@Override
	public Collection<Adherent> getAdherents() {
		return getAll(Adherent.class);
	}

	@SuppressWarnings("unchecked")
	public Collection<String> selectDistinct(String table, String colonne) {
		return executer(session -> session.createQuery("select distinct " + colonne + " from " + table).getResultList());
	}

	@Override
	public Collection<String> getAuteurs() {
		return selectDistinct("auteur", "nom");
	}

	@Override
	public Collection<Exemplaire> getExemplaires() {
		return getAll(Exemplaire.class);
	}

	@Override
	public Exemplaire getExemplaire(String cote, int numero) {
		return get(Exemplaire.class, new ExemplairePK(getOeuvre(cote), numero));
	}

	@Override
	public Collection<Oeuvre> getOeuvres() {
		return getAll(Oeuvre.class);
	}

	@Override
	public Collection<Pret> getPrets() {
		return getAll(Pret.class);
	}

	@Override
	public Pret getPret(int numero) {
		return get(Pret.class, numero);
	}

	@Override
	public Collection<Pret> getPretsEnRetard() {
		// TODO prets en retard
		return null;
	}

	@Override
	public Collection<Reservation> getReservations() {
		return getAll(Reservation.class);
	}

	@Override
	public Adherent getAdherent(int numero) {
		return get(Adherent.class, numero);
	}

	/**
	 * @return les objets de type classe donc le champs colonne vaut valeur
	 */
	private <E> Collection<E> getWhereEquals(Class<E> classe, String colonne, Object valeur) {
		return executer(session -> {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<E> query = builder.createQuery(classe);
			Root<E> root = query.from(classe);
			query.select(root);

			query.where(builder.equal(root.get(colonne), valeur));

			return session.createQuery(query).getResultList();
		});
	}

	@Override
	public Collection<Oeuvre> getOeuvres(String titre) {
		return getWhereEquals(Oeuvre.class, "titre", titre);
	}

	@Override
	public Collection<Adherent> getAdherents(String email) {
		return getWhereEquals(Adherent.class, "email", email);
	}

	private Collection<Oeuvre> getOeuvresManyToMany(String attribut, String valeur) {
		return executer(session -> {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Oeuvre> criteria = builder.createQuery(Oeuvre.class);
			Root<Oeuvre> p = criteria.from(Oeuvre.class);
			criteria.select(p);

			Expression<Collection<String>> auteurs = p.get(attribut);
			criteria.where(builder.isMember(valeur, auteurs));

			TypedQuery<Oeuvre> tq = session.createQuery(criteria);
			return tq.getResultList();
		});
	}

	@Override
	public Collection<Oeuvre> getAuteur(String nom) {
		return getOeuvresManyToMany("auteurs", nom);
	}

	@Override
	public Collection<Oeuvre> getTag(String tag) {
		return getOeuvresManyToMany("tags", tag);
	}

	@Override
	public Oeuvre getOeuvre(String cote) {
		return get(Oeuvre.class, cote);
	}

	@Override
	public Collection<String> getTags() {
		return selectDistinct("tags", "mot");
	}

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