package modele;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Adherent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer numero;

	String nom;
	
	String prenom;

	String email;

	LocalDateTime dateAdhesion;

	LocalDateTime datePaiement;

	Collection<Pret> pretsEnCours;

	Collection<Pret> pretsTerminés;

	Collection<Reservation> reservations;

	@Override
	public String toString() {
		return getNom();
	}
}