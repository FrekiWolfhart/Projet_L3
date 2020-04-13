package projet;

import java.util.Calendar;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "oeuvre", "adherent", "dateEmprunt" })
@Getter
@AllArgsConstructor
public class Pret {

	Oeuvre oeuvre;

	Adherent adherent;

	Calendar dateEmprunt;

	/**
	 * la date théorique de fin de pret (sera une durée sous forme d'Interval en
	 * SQL)
	 */
	Calendar dateFinPret;

	/**
	 * date effective du rendu du pret
	 */
	@Setter(AccessLevel.PRIVATE)
	Calendar dateRendu;

	public Pret(Oeuvre oeuvre, Adherent adherent, Calendar dateEmprunt, Calendar dateFinPret) {
		this.oeuvre = oeuvre;
		this.adherent = adherent;
		this.dateEmprunt = dateEmprunt;
		this.dateFinPret = dateFinPret;
	}

	// TODO : essayer de paramétrer la durée des prets depuis un fichier de
	// configuration (classe Properties)
	public Pret(Oeuvre oeuvre, Adherent adherent, Calendar dateEmprunt) {
		this.oeuvre = oeuvre;
		this.adherent = adherent;
		this.dateEmprunt = dateEmprunt;
		Calendar dateFinPret = Calendar.getInstance();
		dateFinPret.add(Calendar.MONTH, 1);
		this.dateFinPret = dateFinPret;
	}

	public Pret(Oeuvre oeuvre, Adherent adherent) {
		this(oeuvre, adherent, Calendar.getInstance());
	}
	
	public boolean aEteRendu() {
		return dateRendu != null;
	}
	
	public void rendreLivre() {
		if(aEteRendu()) {
			throw new RuntimeException("Le livre " + getOeuvre() + " a déjà été rendu le" + getDateRendu() + " par " + getAdherent()); // TODO : exception personalisée
		}else {
			setDateRendu(Calendar.getInstance());
		}
	}
}