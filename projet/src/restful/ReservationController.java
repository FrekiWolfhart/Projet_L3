package restful;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import controleur.PersistanceServiceLecture;
import controleur.ReservationService;
import modele.Reservation;

@RestController
@SpringBootApplication
@ComponentScan("controleur.implementation")
public class ReservationController {
	@Autowired
	private PersistanceServiceLecture lecture;

	@Autowired
	private ReservationService reservationService;

	@GetMapping("/reservations")
	public Collection<Reservation> getAllReservations() {
		return lecture.getReservations();
	}

	@PostMapping("reserver")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation saveReservationByAdherentId(@RequestBody int idAdhrent, @RequestBody String coteOeuvre) {
		return reservationService.reserver(idAdhrent, coteOeuvre);
	}

//	@PostMapping("reserver")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Reservation saveReservationByAdherent(@RequestBody Adherent adhrent, @RequestBody Oeuvre coteOeuvre) {
//		return reservationService.reserver(adhrent, coteOeuvre);
//	}

}
