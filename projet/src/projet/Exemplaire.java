package projet;

import java.util.Calendar;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(of = { "oeuvre", "numero" })
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class Exemplaire {
	Oeuvre oeuvre;

	int numero;

	Calendar dateAchat;
}
