package restful;

import controleur.PersistanceServiceLecture;
import modele.Adherent;
import modele.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@EnableAutoConfiguration
public class ReservationController {
    @Autowired
    private PersistanceServiceLecture persistance;

    @GetMapping("/Reservations")
    public Collection<Reservation> getAllReservations(){
        return persistance.getReservations();
    }


}
