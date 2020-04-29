package controleur;

import modele.Adherent;

public interface CotisationService {
	public void payerCotisation(int idAdherent);

	public void payerCotisation(Adherent adherent);
}