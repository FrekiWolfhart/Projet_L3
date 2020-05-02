package controleur.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import controleur.DureeCotisationService;
import controleur.EmailService;
import controleur.PersistanceServiceLecture;
import modele.Adherent;

public class EmailServiceImplement implements EmailService {

	@Autowired
	private PersistanceServiceLecture persistance;
	@Autowired
	private DureeCotisationService dureeCotisation;

	@Override
	public void envoyerEmailRetardataires() {
		persistance.getAdherents().stream().filter(adherent -> !dureeCotisation.estCotisationAJour(adherent)).forEach(this::envoyerEmailRetardataire);
	}

	@Override
	public void envoyerEmailRetardataire(Adherent adherent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void envoyerEmail(Adherent adherent, String contenu) {
		// TODO Auto-generated method stub

	}
}