package controleur.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controleur.DateService;
import controleur.FinPretService;
import controleur.PersistanceServiceEcriture;
import controleur.PersistanceServiceLecture;
import modele.Exemplaire;
import modele.Pret;

@Service("finPretService")
public class FinPretServiceImplement implements FinPretService {

	@Autowired
	private PersistanceServiceEcriture ecriture;

	@Autowired
	private PersistanceServiceLecture lecture;

	@Override
	public void rendreLivre(String oeuvre, int numeroExemplaire) {
		Exemplaire exemplaire = lecture.getExemplaire(oeuvre, numeroExemplaire);

		if (exemplaire == null) {
			// TODO
		}

		rendreLivre(exemplaire);
	}

	@Override
	public void rendreLivre(Exemplaire exemplaire) {
		Pret pret = exemplaire.getPretActuel();
		if (pret == null) {
			// TODO
		}
		rendreLivre(pret);
	}

	@Override
	public void rendreLivre(int numeroPret) {
		Pret pret = lecture.getPret(numeroPret);

		if (pret == null) {
			// TODO
		}

		rendreLivre(pret);
	}

	@Override
	public void rendreLivre(Pret pret) {
		pret.setDateRendu(DateService.getDateTime());
		ecriture.mettreAJour(pret);
	}
}