package controleur;

import java.time.LocalDate;

import modele.Auteur;
import modele.Oeuvre;

public interface NouvelleOeuvreService {
	public Oeuvre ajouterOeuvre(String auteur, String titre, String dateSortie);

	public Oeuvre ajouterOeuvre(String auteur, String titre, LocalDate dateSortie);

	public Oeuvre ajouterOeuvre(Auteur auteur, String titre, LocalDate dateSortie);
}