package modele;

import java.time.temporal.Temporal;
import java.util.Collection;
import java.util.HashSet;

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
	int numero;

	String nom;

	String email;

	Temporal dateAdhesion;

	Temporal datePaiement;

	Collection<Pret> pretsEnCours;

	Collection<Pret> pretsTerminés;

	Collection<Reservation> reservations;

	// TODO : voir si c'est à moi de faire ça, ou si Hibernate est assez grand pour le faire tout seul 
	public void ajouterPretEnCours(Pret pret) {
		if (getPretsEnCours() == null) {
			setPretsEnCours(new HashSet<>());
		}
		getPretsEnCours().add(pret);
	}

	public void terminerPret(Pret pret) {

	}

	@Override
	public String toString() {
		return getNom();
	}
}