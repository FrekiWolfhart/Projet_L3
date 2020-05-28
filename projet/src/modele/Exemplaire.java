package modele;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;
import modele.primaryKeys.ExemplairePK;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
@Entity
public class Exemplaire implements Serializable {

	@Delegate
	
	@EmbeddedId
	ExemplairePK id;

	@Column(name = "date_achat", nullable = true)
	LocalDateTime dateAchat;

	@JoinColumn(name = "dernier_pret", nullable = true)
	Pret dernierPret;

	/**
	 * contient également le pretactuel
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "exemplaire")
	Collection<Pret> historiquePrets;

	public boolean estPreté() {
		return !estLibre();
	}
	
	public Pret getPretActuel() {
		 return estLibre() ? null : getDernierPret();
	}

	public boolean estLibre() {
		return getDernierPret() == null || getDernierPret().aEteRendu();
	}

	public Adherent getEmprunteurActuel() {
		return estLibre() ? null : getDernierPret().getAdherent();
	}

	public String toString() {
		return getOeuvre() + " n°" + getNumero();
	};
}