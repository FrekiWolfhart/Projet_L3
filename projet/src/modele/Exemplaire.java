package modele;

import java.time.temporal.Temporal;
import java.util.Collection;

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
@EqualsAndHashCode(of = { "oeuvre", "numero" })
public class Exemplaire {

	Oeuvre oeuvre;

	int numero;

	Temporal dateAchat;

	/**
	 * null si le livre est libre d'être emprunté
	 */
	Pret pretActuel;

	/**
	 * contient également le pretactuel
	 */
	Collection<Pret> historique;

	public boolean estPreté() {
		return pretActuel != null;
	}

	public Adherent getEmprunteurActuel() {
		return getPretActuel() == null ? null : getPretActuel().getAdherent();
	}
	
	public String toString() {
		return getOeuvre() + " n°" + getNumero();
	};
}