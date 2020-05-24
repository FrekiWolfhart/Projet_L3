package modele;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;
import modele.primaryKeys.ReservationPK;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
@EqualsAndHashCode(of = "id")

@Entity
public class Reservation implements Serializable {

	@EmbeddedId
	@Delegate
	ReservationPK id;

	@Column(name = "date_reservation", nullable = false)
	LocalDateTime dateReservation;
	
	@Column(name = "date_proposition", nullable = true)
	LocalDateTime dateProposition;
}