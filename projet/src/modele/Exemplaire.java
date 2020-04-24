package modele;

import java.time.temporal.Temporal;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;
import modele.primaryKeys.ExemplairePK;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
@Entity
public class Exemplaire {

	@EmbeddedId
	@Delegate
	ExemplairePK id;

	Temporal dateAchat;

	/**
	 * null si le livre est libre d'être emprunté
	 */
	Pret pretActuel;

	/**
	 * contient également le pretactuel
	 */
	Collection<Pret> historiquePrets;

	public boolean estPreté() {
		return !estLibre();
	}

	public boolean estLibre() {
		return pretActuel == null;
	}

	public void ajouterhistorique(Pret pret) {
		if (getHistoriquePrets() == null) {
			setHistoriquePrets(new HashSet<>());
		}
		historiquePrets.add(pret);
	}

	public Adherent getEmprunteurActuel() {
		return getPretActuel() == null ? null : getPretActuel().getAdherent();
	}

	public String toString() {
		return getOeuvre() + " n°" + getNumero();
	};
}