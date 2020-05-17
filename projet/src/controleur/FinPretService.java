package controleur;

import modele.Exemplaire;
import modele.Pret;

public interface FinPretService {
	
	public void rendreLivre(int numeroPret);

	public void rendreLivre(Pret pret);

	public void rendreLivre(Exemplaire exemplaire);

	public void rendreLivre(String oeuvre, int exemplaire);
}
