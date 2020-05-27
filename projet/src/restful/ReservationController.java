package restful;

import controleur.PersistanceServiceEcriture;
import controleur.PersistanceServiceLecture;
import controleur.ReservationService;
import modele.Adherent;
import modele.Oeuvre;
import modele.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@EnableAutoConfiguration
public class ReservationController {
    @Autowired
    private PersistanceServiceLecture persistance;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/Reservations")
    public Collection<Reservation> getAllReservations(){
        return persistance.getReservations();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation saveReservationByAdherentId(@RequestBody int idAdhrent ,@RequestBody String coteOeuvre){
        return reservationService.reserver(idAdhrent,coteOeuvre);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation saveReservationByAdherent(@RequestBody Adherent adhrent ,@RequestBody Oeuvre coteOeuvre){
       return reservationService.reserver(adhrent,coteOeuvre);
    }

}
