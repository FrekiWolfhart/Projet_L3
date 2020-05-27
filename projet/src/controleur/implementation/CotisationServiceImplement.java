package controleur.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import controleur.CotisationService;
import controleur.DateService;
import controleur.PersistanceServiceEcriture;
import controleur.PersistanceServiceLecture;
import modele.Adherent;

@Component("cotisationService")
public class CotisationServiceImplement implements CotisationService {

	@Autowired
	private PersistanceServiceEcriture ecriture;
	
	@Autowired
	private PersistanceServiceLecture lecture;

	@Override
	public void payerCotisation(int idAdherent) {
		Adherent adherent = lecture.getAdherent(idAdherent);

		if (adherent == null) {
			// TODO
		}

		payerCotisation(adherent);

	}

	@Override
	public void payerCotisation(Adherent adherent) {
		adherent.setDatePaiement(DateService.getDateTime());
		ecriture.mettreAJour(adherent);
	}
}