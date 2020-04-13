package projet;

import java.util.Calendar;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(of = { "oeuvre", "numero" })
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class Exemplaire {
	/**
	 * cré primaire et étrangère
	 */
	Oeuvre oeuvre;

	/**
	 * cré primaire
	 */
	int numero;

	Calendar dateAchat;

	@Setter(AccessLevel.PRIVATE)
	boolean prêté;

	public Exemplaire(Oeuvre oeuvre, int numero) {
		this(oeuvre, numero, Calendar.getInstance(), false);
	}
}