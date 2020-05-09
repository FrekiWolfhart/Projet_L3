package controleur.implementation;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import controleur.DateService;
import controleur.NouvelleOeuvreService;
import controleur.PersistanceServiceEcriture;
import controleur.StreamOfNullable;
import modele.Auteur;
import modele.Oeuvre;
import modele.Tag;

public class NouvelleOeuvreServiceImplement implements NouvelleOeuvreService {

	@Autowired
	private PersistanceServiceEcriture persistance;

	@Override
	public Oeuvre ajouterOeuvre(String cote, String titre, String dateSortie, Collection<String> auteurs, Collection<String> tags) {
		return ajouterOeuvre(cote, titre, DateService.getDate(dateSortie), auteurs, tags);
	}

	@Override
	public Oeuvre ajouterOeuvre(String cote, String titre, LocalDate dateSortie, Collection<String> nomAuteurs, Collection<String> tagsStrings) {
		Collection<Auteur> auteurs = StreamOfNullable.stream(nomAuteurs).map(persistance::getAuteur).collect(Collectors.toList());
		Collection<Tag> tags = StreamOfNullable.stream(tagsStrings).map(persistance::getTag).collect(Collectors.toList());

		Oeuvre oeuvre = persistance.getOeuvre(cote);

		if (oeuvre != null) {
			// TODO : faire quelque chose si l'oeuvre existe déjà
		}

		oeuvre = new Oeuvre(cote, auteurs, titre, dateSortie, tags, null, null);

		persistance.enregistrer(oeuvre);

		return oeuvre;
	}
}