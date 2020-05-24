package modele.primaryKeys;

import java.io.Serializable;

import javax.persistence.Column;
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
import modele.Oeuvre;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode

@Embeddable
public class ExemplairePK implements Serializable {
	@ManyToOne
	@JoinColumn(name = "cote", nullable = false)
	Oeuvre oeuvre;
	@Column(name = "numero", nullable = false)
	Integer numero;
}
