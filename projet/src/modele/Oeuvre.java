package modele;

import java.time.temporal.Temporal;
import java.util.Collection;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "cote")
public class Oeuvre {

	/**
	 * cré primaire
	 */
	String cote;
	
	// TODO : peut-être rajouter un attribut nbExemplaires (en java et en BDD)

	/**
	 * une autre table contiendra un auteur et une cote Hibernate se chargera ensuite d'allimenter cet attribut
	 */
	Collection<Auteur> auteurs;

	String titre;

	Temporal dateParution;

	Collection<String> tags;

	Collection<Exemplaire> exemplaires;

	Collection<Reservation> reservations;

	@Override
	public String toString() {
		return getTitre();
	}
}