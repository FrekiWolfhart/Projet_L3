package controleur.implementation;

import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import controleur.DateService;
import controleur.DureeCotisationService;
import controleur.PersistanceServiceLecture;
import modele.Adherent;

@Component("dureeCotisationService")
public class DureeCotisationServiceImplement implements DureeCotisationService {

	@Autowired
	private PersistanceServiceLecture lecture;

	@Override
	public Period getDureeCotisation() {
		// TODO : utiliser un ficher de configuration https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Properties.html
		return Period.ofMonths(1);
	}

	@Override
	public boolean estCotisationAJour(int adherentId) {
		Adherent adherent = lecture.getAdherent(adherentId);
		if (adherent == null) {
			// TODO
		}

		return estCotisationAJour(adherent);
	}

	@Override
	public boolean estCotisationAJour(Adherent adherent) {
		return adherent.getDatePaiement().plus(getDureeCotisation()).isAfter(DateService.getDateTime());
	}
}