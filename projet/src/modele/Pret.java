package modele;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

import javax.persistence.EmbeddedId;

import controleur.ServicesFormatageDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;
import modele.primaryKeys.PretPK;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
public class Pret {

	@EmbeddedId
	@Delegate
	PretPK id;

	/**
	 * la date théorique de fin de pret (sera une durée sous forme d'Interval en SQL)
	 */
	Duration duréeThéorique;

	/**
	 * date effective du rendu du pret
	 */
	Temporal dateRendu;

	public boolean aEteRendu() {
		return dateRendu != null;
	}
	
	public Pret(Adherent adherent, Exemplaire exemplaire, Temporal dateEmprunt, Duration duréeThéorique) {
		this(new PretPK(exemplaire, adherent, dateEmprunt), duréeThéorique, dateEmprunt);
	}

	public void setDateRendu() {
		setDateRendu(LocalDateTime.now());
	}

	@Override
	public String toString() {
		return "le livre " + getExemplaire() + " prete le " + ServicesFormatageDate.toStringdateHeure(getDateEmprunt()) + " à " + getAdherent();
	}
}