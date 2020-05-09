package modele;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.Id;

import controleur.StreamOfNullable;
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
@EqualsAndHashCode(of = "cote")
@Entity
public class Oeuvre {

	@Id
	String cote;

	Collection<Auteur> auteurs;

	String titre;

	LocalDate dateParution;

	Collection<Tag> tags;

	Collection<Exemplaire> exemplaires;

	Collection<Reservation> reservations;

	/**
	 * @return un exemplaire qui n'est pas prété (ou null)
	 */
	public Exemplaire getExemplaireLibre() {
		return getExemplairesLibres().findAny().orElse(null);
	}

	public Stream<Exemplaire> getExemplairesLibres() {
		return getExemplairesStream().filter(Exemplaire::estLibre);
	}

	public Stream<Exemplaire> getExemplairesPretes() {
		return getExemplairesStream().filter(Exemplaire::estPreté);
	}

	public Stream<Exemplaire> getExemplairesStream() {
		return StreamOfNullable.stream(getExemplaires());
	}

	public Stream<Reservation> getReservationStream() {
		return StreamOfNullable.stream(getReservations());
	}

	public Stream<Pret> getPrets() {
		return getExemplairesStream().map(Exemplaire::getHistoriquePrets).flatMap(StreamOfNullable::stream);
	}

	public long getNbExemplairesPretes() {
		return getExemplairesPretes().count();
	}

	public long getNbExemplairesLibres() {
		return getExemplairesLibres().count();
	}

	@Override
	public String toString() {
		return getTitre();
	}
}