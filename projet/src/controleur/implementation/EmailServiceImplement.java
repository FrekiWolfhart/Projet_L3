package controleur.implementation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import controleur.DureePretService;
import controleur.EmailService;
import controleur.PersistanceServiceLecture;
import modele.Adherent;
import modele.Pret;

public class EmailServiceImplement implements EmailService {

	@Autowired
	private PersistanceServiceLecture persistance;
	@Autowired
	private DureePretService dureePret;

	@Override
	public void envoyerEmailRetardataires() {
		// TODO
	}

	@Override
	public void envoyerEmailRetardataire(Adherent adherent, Collection<Pret> pretsEnRetard) {
		// TODO Auto-generated method stub

	}

	@Override
	public void envoyerEmail(Adherent adherent, String contenu) {
		// TODO Auto-generated method stub

	}
}