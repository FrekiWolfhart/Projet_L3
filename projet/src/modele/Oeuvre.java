package modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Stream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "oeuvre")
public class Oeuvre implements Serializable {

	@Id
	@Column(name = "cote")
	@ManyToOne
	String cote;

	@Column(name = "titre")
	String titre;

	@Column(name = "date_parution")
	LocalDate dateParution;

	@OneToMany
	Collection<String> auteurs; // TODO
	
	@OneToMany
	Collection<String> tags; // TODO

	@OneToMany(mappedBy = "oeuvre")
	Collection<Exemplaire> exemplaires;

	@OneToMany(mappedBy = "oeuvre")
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