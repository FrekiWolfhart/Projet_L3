package controleur.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import controleur.DateService;
import controleur.FinPretService;
import controleur.PersistanceServiceEcriture;
import modele.Exemplaire;
import modele.Pret;

public class FinPretServiceImplement implements FinPretService {

	@Autowired
	private PersistanceServiceEcriture persistance;

	@Override
	public void rendreLivre(String oeuvre, int numeroExemplaire) {
		Exemplaire exemplaire = persistance.getExemplaire(oeuvre, numeroExemplaire);

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
		Pret pret = persistance.getPret(numeroPret);

		if (pret == null) {
			// TODO
		}

		rendreLivre(pret);
	}

	@Override
	public void rendreLivre(Pret pret) {
		pret.setDateRendu(DateService.getDateTime());
		persistance.mettreAJour(pret);
	}
}