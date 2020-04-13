package projet;

/**
 * on utilise la date du package SQL car on n'a pas besoin de l'heure exacte, le jour nous suffit
 */
import java.sql.Date;
import java.util.Collection;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "cote" )
@AllArgsConstructor
@Getter
@ToString(of = "titre")
public class Oeuvre {

	/**
	 * cré primaire
	 */
	String cote;

	/**
	 * une autre table contiendra un auteur et une cote Hibernate se chargera
	 * ensuite d'allimenter cet attribut
	 */
	Collection<Auteur> auteurs;

	String titre;

	Date dateParution;

	Collection<String> tags;

	Collection<Exemplaire> exemplaires;
}