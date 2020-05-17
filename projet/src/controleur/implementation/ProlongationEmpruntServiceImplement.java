package controleur.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import controleur.PersistanceServiceEcriture;
import controleur.ProlongationEmpruntService;
import modele.Exemplaire;
import modele.Pret;

public class ProlongationEmpruntServiceImplement implements ProlongationEmpruntService {

	@Autowired
	private PersistanceServiceEcriture persistance;

	@Override
	public boolean prolonger(String coteOeuvre, int numeroExemplaire) {
		Exemplaire exemplaire = persistance.getExemplaire(coteOeuvre, numeroExemplaire);

		if (exemplaire == null) {
			// TODO
		}

		return prolonger(exemplaire);

	}

	@Override
	public boolean prolonger(Exemplaire exemplaire) {
		Pret pret = exemplaire.getPretActuel();

		if (pret == null) {
			// TODO
		}

		return prolonger(pret);
	}

	@Override
	public boolean prolonger(int numeroPret) {
		Pret pret = persistance.getPret(numeroPret);

		if (pret == null) {
			// TODO
		}

		return prolonger(pret);
	}

	@Override
	public boolean prolonger(Pret pret) {
		// TODO Auto-generated method stub
		return false;
	}
}
