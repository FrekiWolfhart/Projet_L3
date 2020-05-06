package controleur.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import controleur.NouvelAdherentService;
import controleur.PersistanceServiceEcriture;
import modele.Adherent;

public class NouvelAdherentServiceImplement implements NouvelAdherentService {

	@Autowired
	private PersistanceServiceEcriture persistance;
	
	@Override
	public Adherent ajouterAdherent(String nom, String email) {
		Adherent adherent = new Adherent().setNom(nom).setEmail(email);
		persistance.enregistrer(adherent);
		return adherent;
	}
}