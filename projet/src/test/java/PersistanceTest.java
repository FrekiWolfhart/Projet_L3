package test.java;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;

import controleur.DateService;
import controleur.PersistanceServiceEcriture;
import controleur.implementation.PersistanceImplement;
import modele.Adherent;
import modele.Oeuvre;

public class PersistanceTest {

	PersistanceServiceEcriture persistance = new PersistanceImplement();

	@Test
	public void test() {
		verifierQueLestablesSontVides();
		Adherent adherent1 = new Adherent(null, "nom1", "prenom1", "email1", DateService.getDateTime(), DateService.getDateTime(), null, null);
		persistance.enregistrer(adherent1);
		Oeuvre oeuvre1 = new Oeuvre("cote1", "titre1", DateService.getDate("2007-12-03"), Arrays.asList("Auteur1", "Auteur2"), Arrays.asList("tag1", "tag2"), null, null);
		
		persistance.enregistrer(oeuvre1);
	}

	private void verifierQueLestablesSontVides() {
		vérifierQueLaTableSoitVide(persistance.getAdherents());
		vérifierQueLaTableSoitVide(persistance.getOeuvres());
		// du fait des clés étrangères, les autres tabless ne peuvent être que vide
	}

	private void vérifierQueLaTableSoitVide(Collection<?> contenu) {
		assertThat("Assurez vous que toutes les tables soient vides avant de lancer les tests", contenu, empty());
	}
}
