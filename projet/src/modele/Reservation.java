package modele;

import java.time.temporal.Temporal;

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
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
@EqualsAndHashCode(of = { "adherent", "oeuvre" })
public class Reservation {
	Adherent adherent;
	Oeuvre oeuvre;
	Temporal date;
}