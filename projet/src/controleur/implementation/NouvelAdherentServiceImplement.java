package controleur.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controleur.NouvelAdherentService;
import controleur.PersistanceServiceEcriture;
import modele.Adherent;

@Service("nouvelAdherentService")
public class NouvelAdherentServiceImplement implements NouvelAdherentService {

	@Autowired
	private PersistanceServiceEcriture ecriture;

	@Override
	public Adherent ajouterAdherent(String nom, String prenom, String email) {
		Adherent adherent = new Adherent().setNom(nom).setPrenom(prenom).setEmail(email);
		ecriture.enregistrer(adherent);
		return adherent;
	}
}