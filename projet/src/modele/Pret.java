package modele;

import java.time.LocalDateTime;
import java.time.Period;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "numero")
public class Pret {

	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer numero;
	
	Exemplaire exemplaire;

	Adherent adherent;

	LocalDateTime dateEmprunt;

	/**
	 * la date théorique de fin de pret (sera une durée sous forme d'Interval en SQL)
	 */
	Period duréeThéorique;

	/**
	 * date effective du rendu du pret
	 */
	LocalDateTime dateRendu;

	public boolean aEteRendu() {
		return dateRendu != null;
	}

	public Pret(Adherent adherent, Exemplaire exemplaire, LocalDateTime dateEmprunt, Period duréeThéorique) {
		this(null, exemplaire, adherent, dateEmprunt, duréeThéorique, dateEmprunt);
	}

	@Override
	public String toString() {
		return "le livre " + getExemplaire() + " prete le " + getDateEmprunt() + " à " + getAdherent();
	}
}