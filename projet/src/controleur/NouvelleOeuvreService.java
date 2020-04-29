package controleur;

import java.time.temporal.Temporal;

import modele.Auteur;
import modele.Oeuvre;

public interface NouvelleOeuvreService {
	public Oeuvre ajouterOeuvre(String auteur, String titre, String dateSortie);

	public Oeuvre ajouterOeuvre(String auteur, String titre, Temporal dateSortie);

	public Oeuvre ajouterOeuvre(Auteur auteur, String titre, Temporal dateSortie);
}