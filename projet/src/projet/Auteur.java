package projet;

import java.util.Collection;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = { "nom" })
public class Auteur {
	String nom;
	Collection<Oeuvre> oeuvres;
}