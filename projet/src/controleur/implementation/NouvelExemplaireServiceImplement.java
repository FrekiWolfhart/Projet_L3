package controleur.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controleur.DateService;
import controleur.MyCollectionUtils;
import controleur.NouvelExemplaireService;
import controleur.PersistanceServiceEcriture;
import controleur.PersistanceServiceLecture;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.primaryKeys.ExemplairePK;

@Service("nouvelExemplaireService")
public class NouvelExemplaireServiceImplement implements NouvelExemplaireService {

	@Autowired
	private PersistanceServiceEcriture ecriture;

	@Autowired
	private PersistanceServiceLecture lecture;

	@Override
	public Exemplaire ajouterExemplaire(String coteOeuvre) {
		Oeuvre oeuvre = lecture.getOeuvre(coteOeuvre);
		if (oeuvre == null) {
			// TODO
		}
		return ajouterExemplaire(oeuvre);
	}

	@Override
	public Exemplaire ajouterExemplaire(Oeuvre oeuvre) {
		Exemplaire exemplaire;
		String cote = oeuvre.getCote().intern();
		synchronized (cote) {
			int numero = MyCollectionUtils.stream(oeuvre.getExemplaires()).mapToInt(Exemplaire::getNumero).max().orElse(0) + 1;
			exemplaire = new Exemplaire().setId(new ExemplairePK(oeuvre, numero)).setDateAchat(DateService.getDateTime());
			ecriture.enregistrer(exemplaire);
		}
		return exemplaire;
	}
}