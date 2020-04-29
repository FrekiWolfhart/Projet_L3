package controleur;

import java.time.Duration;

import modele.Adherent;

public interface DureeCotisationService {
	public Duration getDureeCotisation();

	public boolean estCotisationAJour(Adherent adherent);
}