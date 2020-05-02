package controleur.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import controleur.CotisationService;
import controleur.DateService;
import controleur.PersistanceServiceEcriture;
import modele.Adherent;

public class CotisationServiceImplement implements CotisationService {

	@Autowired
	private PersistanceServiceEcriture persistance;

	@Override
	public void payerCotisation(int idAdherent) {
		Adherent adherent = persistance.getAdherent(idAdherent);

		if (adherent == null) {
			// TODO
		}

		payerCotisation(adherent);

	}

	@Override
	public void payerCotisation(Adherent adherent) {
		adherent.setDatePaiement(DateService.getDateTime());
		persistance.mettreAJour(adherent);
	}
}