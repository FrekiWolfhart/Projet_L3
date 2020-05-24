package modele;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@EqualsAndHashCode(of = "numero")

@Entity
@Table(name = "adherent")
public class Adherent implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	Integer numero;

	@Column(name = "nom", nullable = false)
	String nom;

	@Column(name = "prenom", nullable = false)
	String prenom;

	@Column(name = "email", nullable = false)
	String email;

	@Column(name = "date_adhesion", nullable = false)
	LocalDateTime dateAdhesion;

	@Column(name = "date_paiement", nullable = true)
	LocalDateTime datePaiement;

	@OneToMany(mappedBy = "adherent")
	Collection<Pret> prets;

	@OneToMany(mappedBy = "adherent")
	Collection<Reservation> reservations;

	@Override
	public String toString() {
		return getNom();
	}
}