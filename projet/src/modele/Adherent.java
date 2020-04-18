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
@EqualsAndHashCode(of = "numero")
public class Adherent {
	/**
	 * cré primaire
	 */
	int numero;
	String nom;
	String email;
	Temporal dateAdhesion;

	Temporal datePaiement;

	Collection<Pret> pretsEnCours;

	Collection<Pret> pretsTerminés;

	Collection<Reservation> reservations;

	@Override
	public String toString() {
		return getNom();
	}
}