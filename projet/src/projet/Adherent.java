package projet;

import java.util.Calendar;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(of = { "numero" })
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@ToString(of = "nom")
public class Adherent {
	/**
	 * cré primaire
	 */
	int numero;
	String nom;
	String email;
	Calendar dateAdhesion;

	@Setter(AccessLevel.PRIVATE)
	Calendar datePaiement;

	/**
	 * met la date de paiement à maintenant
	 */
	public void majDatePaiement() {
		setDatePaiement(Calendar.getInstance());
	}

	public Adherent(int numero, String nom, String adresse, Calendar dateAdhesion) {
		this(numero, nom, adresse, dateAdhesion, dateAdhesion);
	}

	public Adherent(int numero, String nom, String adresse) {
		this(numero, nom, adresse, Calendar.getInstance());
	}
}