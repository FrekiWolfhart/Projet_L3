package controleur.implementation;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Repository;

import controleur.PersistanceServiceLecture;
import modele.Adherent;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.Pret;
import modele.Reservation;
import modele.primaryKeys.ExemplairePK;

@Repository("lecture")
public class LectureImplement extends AbstractPersistance implements PersistanceServiceLecture {

	private <E> Collection<E> getAll(Class<E> classe) {
//		return executer(session -> session.createCriteria(classe).list());
		return executer(session -> {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<E> query = builder.createQuery(classe);
			Root<E> root = query.from(classe);
			query.select(root);

			return session.createQuery(query).getResultList();
		});
	}

	private <E> E get(Class<E> classe, Serializable id) {
		return executer(session -> session.get(classe, id));
	}

	// TODO : utiliser criteria
	@SuppressWarnings("unchecked")
	public Collection<String> selectDistinct(String table, String colonne) {
		return executer(session -> session.createQuery("select distinct " + colonne + " from " + table).getResultList());
	}

	@Override
	public Collection<Adherent> getAdherents() {
		return getAll(Adherent.class);
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
		throw new NotYetImplementedException();
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
	public Collection<Adherent> getAdherents(String email) {
		return getWhereEquals(Adherent.class, "email", email);
	}

	private Collection<Oeuvre> getOeuvresManyToMany(String attribut, String valeur) {
		return executer(session -> {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Oeuvre> criteria = builder.createQuery(Oeuvre.class);
			Root<Oeuvre> p = criteria.from(Oeuvre.class);
			criteria.select(p);

			Expression<Collection<String>> valeurs = p.get(attribut);
			criteria.where(builder.isMember(valeur, valeurs));

			TypedQuery<Oeuvre> tq = session.createQuery(criteria);
			return tq.getResultList();
		});
	}

	@Override
	public Collection<Oeuvre> getAuteur(String nom) {
		return getOeuvresManyToMany("auteurs", nom);
	}

	@Override
	public Oeuvre getOeuvre(String cote) {
		return get(Oeuvre.class, cote);
	}

	@Override
	public Collection<Oeuvre> getOeuvres(String titre) {
		return getWhereEquals(Oeuvre.class, "titre", titre);
	}

	@Override
	public Collection<String> getTags() {
		return selectDistinct("tags", "mot");
	}

	@Override
	public Collection<Oeuvre> getTag(String tag) {
		return getOeuvresManyToMany("tags", tag);
	}

}
