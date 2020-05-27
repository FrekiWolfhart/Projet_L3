package controleur.implementation;

import java.util.function.Function;

import org.hibernate.Session;
import org.hibernate.Transaction;

class AbstractPersistance {
	private Session getSession() {
		return SessionUtils.instance.getSession();
	}

	/**
	 * créer une transaction et effectu un commit à la fin de la transaction
	 * 
	 * @param <E>
	 */
	protected <E> E executer(Function<Session, E> fonction) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();

		E result = fonction.apply(session);

		tx.commit();

		return result;
	}
}
