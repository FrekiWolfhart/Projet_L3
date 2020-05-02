package controleur.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import controleur.DateService;
import controleur.DureeCotisationService;
import controleur.DureePretService;
import controleur.NouvelEmpruntService;
import controleur.PersistanceServiceEcriture;
import modele.Adherent;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.Pret;

public class NouvelEmpruntServiceImplement implements NouvelEmpruntService {
	
	@Autowired
	private DureeCotisationService dureeCotisationService;
	
	@Autowired
	private PersistanceServiceEcriture persistance;
	
	@Autowired
	private DureePretService dureePretService;

	@Override
	public Pret emprunter(Adherent adherent, Exemplaire exemplaire) {
		if (exemplaire.estPreté()) {
//			throw new DejaPreteException(exemplaire, adherent); // TODO
		}
		
		if(!dureeCotisationService.estCotisationAJour(adherent)) {
			// TODO
		}
		
		Pret pret = new Pret(adherent, exemplaire, DateService.getDateTime(), dureePretService.getDuree());

		persistance.enregistrer(pret);

		return pret;
	}

	@Override
	public Pret emprunter(Adherent adherent, Oeuvre oeuvre) {
		Exemplaire libre = oeuvre.getExemplaireLibre();

		if (libre == null) {
//			throw new AucunExemplaireLibreException(oeuvre); // TODO
		}

		return emprunter(adherent, libre);
	}

	@Override
	public Pret emprunter(int idAdherent, String coteOeuvre, int numeroExemplaire) {
		Adherent adherent = persistance.getAdherent(idAdherent);

		if (adherent == null) {
			// TODO
		}

		Exemplaire exemplaire = persistance.getExemplaire(coteOeuvre, numeroExemplaire);

		if (exemplaire == null) {
			// TODO
		}

		return emprunter(adherent, exemplaire);
	}

	@Override
	public Pret emprunter(int idAdherent, String coteOeuvre) {
		Adherent adherent = persistance.getAdherent(idAdherent);
		if (adherent == null) {
			// TODO
		}

		Oeuvre oeuvre = persistance.getOeuvre(coteOeuvre);
		if (oeuvre == null) {
			// TODO
		}

		return emprunter(adherent, oeuvre);
	}
}