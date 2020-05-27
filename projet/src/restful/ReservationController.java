package restful;

import controleur.PersistanceServiceEcriture;
import controleur.PersistanceServiceLecture;
import modele.Adherent;
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
    private PersistanceServiceEcriture persistanceServiceEcriture;

    @GetMapping("/Reservations")
    public Collection<Reservation> getAllReservations(){
        return persistance.getReservations();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveReservation(@RequestBody Reservation reservation){
        persistanceServiceEcriture.enregistrer(reservation);
    }

}
