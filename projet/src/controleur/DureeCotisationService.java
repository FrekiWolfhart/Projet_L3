package controleur;

import java.time.Period;

import modele.Adherent;

public interface DureeCotisationService {
	public Period getDureeCotisation();

	public boolean estCotisationAJour(Adherent adherent);
	
	public boolean estCotisationAJour(int adherent);
}