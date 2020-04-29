package controleur;

import modele.Exemplaire;
import modele.Oeuvre;

public interface NouvelExemplaireService {
	public Exemplaire ajouterExemplaire(String coteOeuvre);

	public Exemplaire ajouterExemplaire(Oeuvre oeuvre);
}