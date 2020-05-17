package controleur;

import modele.Exemplaire;
import modele.Pret;

public interface ProlongationEmpruntService {
	public boolean prolonger(String coteOeuvre, int numeroExemplaire);

	public boolean prolonger(Exemplaire exemplaire);
	
	public boolean prolonger(int numeroPret);

	public boolean prolonger(Pret pret);
}
