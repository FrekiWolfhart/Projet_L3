package controleur;

import java.time.LocalDate;
import java.util.Collection;

import modele.Oeuvre;

public interface NouvelleOeuvreService {
	public Oeuvre ajouterOeuvre(String cote, String titre, String dateSortie, Collection<String> auteurs, Collection<String> tags);

	public Oeuvre ajouterOeuvre(String cote, String titre, LocalDate dateSortie, Collection<String> auteurs, Collection<String> tags);
}