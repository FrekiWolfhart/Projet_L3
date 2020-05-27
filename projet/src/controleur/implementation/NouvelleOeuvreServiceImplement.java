package controleur.implementation;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controleur.DateService;
import controleur.NouvelleOeuvreService;
import controleur.PersistanceServiceEcriture;
import controleur.PersistanceServiceLecture;
import modele.Oeuvre;

@Service("nouvelleOeuvreService")
public class NouvelleOeuvreServiceImplement implements NouvelleOeuvreService {

	@Autowired
	private PersistanceServiceEcriture ecriture;

	@Autowired
	private PersistanceServiceLecture lecture;

	@Override
	public Oeuvre ajouterOeuvre(String cote, String titre, String dateSortie, Collection<String> auteurs, Collection<String> tags) {
		return ajouterOeuvre(cote, titre, DateService.getDate(dateSortie), auteurs, tags);
	}

	@Override
	public Oeuvre ajouterOeuvre(String cote, String titre, LocalDate dateSortie, Collection<String> auteurs, Collection<String> tags) {

		Oeuvre oeuvre = lecture.getOeuvre(cote);

		if (oeuvre != null) {
			// TODO : faire quelque chose si l'oeuvre existe déjà
		}

		oeuvre = new Oeuvre(cote, titre, dateSortie, auteurs, tags, null, null);

		ecriture.enregistrer(oeuvre);

		return oeuvre;
	}
}