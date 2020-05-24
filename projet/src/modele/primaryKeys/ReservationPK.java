package modele.primaryKeys;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import modele.Adherent;
import modele.Oeuvre;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode

@Embeddable
public class ReservationPK implements Serializable {
	@ManyToOne
	@JoinColumn(name = "id_adherent", nullable = false)
	Adherent adherent;
	
	@ManyToOne
	@JoinColumn(name = "cote", nullable = false)
	Oeuvre oeuvre;
}