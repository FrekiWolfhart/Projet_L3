package controleur.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import controleur.PersistanceServiceEcriture;
import controleur.PersistanceServiceLecture;
import controleur.ProlongationEmpruntService;
import modele.Exemplaire;
import modele.Pret;

@Component("prolongationEmpruntService")
public class ProlongationEmpruntServiceImplement implements ProlongationEmpruntService {

	@Autowired
	private PersistanceServiceEcriture ecriture;
	@Autowired
	private PersistanceServiceLecture lecture;

	@Autowired
	private DureePretServiceImplement dureePretService;

	@Override
	public boolean prolonger(String coteOeuvre, int numeroExemplaire) {
		Exemplaire exemplaire = lecture.getExemplaire(coteOeuvre, numeroExemplaire);

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
		Pret pret = lecture.getPret(numeroPret);

		if (pret == null) {
			// TODO
		}

		return prolonger(pret);
	}

	@Override
	public boolean prolonger(Pret pret) {
		// vérifier qu'on puisse bien le faire (qu'il n'y a pas de reservations par exemple)

		pret.setDuréeThéorique(pret.getDuréeThéorique().plus(dureePretService.getDuree()));

		ecriture.mettreAJour(pret);

		return true;
	}
}
