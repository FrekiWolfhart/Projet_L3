package controleur.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controleur.DateService;
import controleur.NouvelAdherentService;
import controleur.PersistanceServiceEcriture;
import modele.Adherent;

@Service("nouvelAdherentService")
public class NouvelAdherentServiceImplement implements NouvelAdherentService {

	@Autowired
	private PersistanceServiceEcriture ecriture;

	// TODO : vérifier que l'email soit dans le bon format
	@Override
	public Adherent ajouterAdherent(String nom, String prenom, String email) {
		Adherent adherent = new Adherent(null, nom, prenom, email, DateService.getDateTime(), null, null, null);
		ecriture.enregistrer(adherent);
		return adherent;
	}
}