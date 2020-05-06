package controleur.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import controleur.DateService;
import controleur.PersistanceServiceEcriture;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.primaryKeys.ExemplairePK;

public class NouvelExemplaireServiceImplement implements controleur.NouvelExemplaireService {

	@Autowired
	private PersistanceServiceEcriture persistance;
	
	@Override
	public Exemplaire ajouterExemplaire(String coteOeuvre) {
		Oeuvre oeuvre = persistance.getOeuvre(coteOeuvre);
		if(oeuvre == null) {
			
		}
		return ajouterExemplaire(oeuvre);
	}

	@Override
	public Exemplaire ajouterExemplaire(Oeuvre oeuvre) {
		Exemplaire exemplaire = new Exemplaire().setId(new ExemplairePK().setOeuvre(oeuvre)).setDateAchat(DateService.getDateTime());
		persistance.enregistrer(exemplaire);
		return exemplaire;
	}
}