package modele;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

import controleur.ServicesDivers;
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
@EqualsAndHashCode(of = { "exemplaire", "adherent", "dateEmprunt" })
public class Pret {

	Exemplaire exemplaire;

	Adherent adherent;

	Temporal dateEmprunt;

	/**
	 * la date théorique de fin de pret (sera une durée sous forme d'Interval en SQL)
	 */
	Duration duréeThéorique;

	/**
	 * date effective du rendu du pret
	 */
	Temporal dateRendu;

	ServicesDivers services;

	public boolean aEteRendu() {
		return dateRendu != null;
	}

	public void setDateRendu() {
		setDateRendu(LocalDateTime.now());
	}

	
	// TODO : faire une injection pour bien formater les dates
	@Override
	public String toString() {
		return "le livre " + getExemplaire() + " prete le " + getDateEmprunt() + " à " + getAdherent();
	}
}