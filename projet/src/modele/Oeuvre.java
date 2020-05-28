package modele;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Stream;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import controleur.MyCollectionUtils;
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
	@Column(name = "cote", nullable = false)
	String cote;

	@Column(name = "titre", nullable = false)
	String titre;

	@Column(name = "date_parution", nullable = true)
	LocalDate dateParution;

	@ElementCollection
	@CollectionTable(name = "auteur", joinColumns = @JoinColumn(name = "cote"))
	@Column(name = "nom")
	Collection<String> auteurs;

	@ElementCollection
	@CollectionTable(name = "tag", joinColumns = @JoinColumn(name = "cote"))
	@Column(name = "mot")
	Collection<String> tags;

	@OneToMany(mappedBy = "id.oeuvre")
	Collection<Exemplaire> exemplaires;

	@OneToMany(mappedBy = "id.oeuvre")
	Collection<Reservation> reservations;

	/**
	 * @return un exemplaire qui n'est pas prété (ou null)
	 */
	public Exemplaire getExemplaireLibre() {
		return getExemplairesLibres().findAny().orElse(null);
	}

	// TODO : faire tout ça direcement côté BDD
	
	public Stream<Exemplaire> getExemplairesLibres() {
		return getExemplairesStream().filter(Exemplaire::estLibre);
	}

	public Stream<Exemplaire> getExemplairesPretes() {
		return getExemplairesStream().filter(Exemplaire::estPreté);
	}

	public Stream<Exemplaire> getExemplairesStream() {
		return MyCollectionUtils.stream(getExemplaires());
	}

	public Stream<Reservation> getReservationStream() {
		return MyCollectionUtils.stream(getReservations());
	}

	public Stream<Pret> getPrets() {
		return getExemplairesStream().map(Exemplaire::getHistoriquePrets).flatMap(MyCollectionUtils::stream);
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