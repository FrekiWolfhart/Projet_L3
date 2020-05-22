package modele;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Adherent implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer numero;

	String nom;
	
	String prenom;

	String email;

	LocalDateTime dateAdhesion;

	LocalDateTime datePaiement;
	
	@OneToMany
	Collection<Pret> prets;

	@OneToMany
	Collection<Reservation> reservations;

	@Override
	public String toString() {
		return getNom();
	}
}