package controleur.implementation;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import controleur.DateService;
import controleur.NouvelleOeuvreService;
import controleur.PersistanceServiceEcriture;
import modele.Oeuvre;

public class NouvelleOeuvreServiceImplement implements NouvelleOeuvreService {

	@Autowired
	private PersistanceServiceEcriture persistance;

	@Override
	public Oeuvre ajouterOeuvre(String cote, String titre, String dateSortie, Collection<String> auteurs, Collection<String> tags) {
		return ajouterOeuvre(cote, titre, DateService.getDate(dateSortie), auteurs, tags);
	}

	@Override
	public Oeuvre ajouterOeuvre(String cote, String titre, LocalDate dateSortie, Collection<String> auteurs, Collection<String> tags) {

		Oeuvre oeuvre = persistance.getOeuvre(cote);

		if (oeuvre != null) {
			// TODO : faire quelque chose si l'oeuvre existe déjà
		}

		oeuvre = new Oeuvre(cote, titre, dateSortie, auteurs, tags, null, null);

		persistance.enregistrer(oeuvre);

		return oeuvre;
	}
}