//package test.java;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.hamcrest.collection.IsEmptyCollection.empty;
//import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//import org.junit.jupiter.api.Test;
//
//import controleur.DateService;
//import controleur.PersistanceServiceEcriture;
//import controleur.implementation.PersistanceImplement;
//import modele.Adherent;
//import modele.Oeuvre;
//
//public class PersistanceTest {
//
//	PersistanceServiceEcriture persistance = new PersistanceImplement();
//
//	@Test
//	public void test() {
//		verifierQueLestablesSontVides();
//		Adherent adherent1 = new Adherent(null, "nom1", "prenom1", "email1", DateService.getDateTime(), DateService.getDateTime(), null, null);
//		persistance.enregistrer(adherent1);
//		String auteur1 = "Auteur1";
//		String auteur2 = "Auteur2";
//		String tag1 = "tag1";
//		String tag2 = "tag2";
//		Oeuvre oeuvre1 = new Oeuvre("cote1", "Titre1", DateService.getDate("2007-12-03"), Arrays.asList(auteur1, auteur2), Arrays.asList(tag1, tag2), null, null);
//
//		persistance.enregistrer(oeuvre1);
//		Collection<Oeuvre> oeuvresDeAuteur1 = persistance.getAuteur(auteur1);
//		assertThat(oeuvresDeAuteur1, hasSize(1));
//		assertThat(oeuvresDeAuteur1, containsInAnyOrder(oeuvre1));
//
//		Collection<Oeuvre> oeuvresDeAuteur2 = persistance.getAuteur(auteur2);
//		assertThat(oeuvresDeAuteur2, hasSize(1));
//		assertThat(oeuvresDeAuteur2, containsInAnyOrder(oeuvre1));
//
//		Oeuvre oeuvre2 = new Oeuvre("cote2", "Titre2", DateService.getDate("2008-05-10"), Arrays.asList(auteur2), Arrays.asList(tag2), null, null);
//
//		persistance.enregistrer(oeuvre2);
//
//		oeuvresDeAuteur1 = persistance.getAuteur(auteur1);
//		assertThat(oeuvresDeAuteur1, hasSize(1));
//		assertThat(oeuvresDeAuteur1, containsInAnyOrder(oeuvre1));
//
//		oeuvresDeAuteur2 = persistance.getAuteur(auteur2);
//		assertThat(oeuvresDeAuteur2, hasSize(2));
//		assertThat(oeuvresDeAuteur2, containsInAnyOrder(oeuvre1, oeuvre2));
//	}
//
//	private void verifierQueLestablesSontVides() {
//		vérifierQueLaTableSoitVide(persistance.getAdherents());
//		vérifierQueLaTableSoitVide(persistance.getOeuvres());
//		// du fait des clés étrangères, les autres tabless ne peuvent être que vide
//	}
//
//	private void vérifierQueLaTableSoitVide(Collection<?> contenu) {
//		assertThat("Assurez vous que toutes les tables soient vides avant de lancer les tests", contenu, empty());
//	}
//}
