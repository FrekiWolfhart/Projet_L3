package restful;

import controleur.PersistanceServiceEcriture;
import controleur.PersistanceServiceLecture;
import controleur.implementation.PersistanceImplement;
import modele.Adherent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@EnableAutoConfiguration
public class AdherentController {

    @Autowired
    private PersistanceServiceLecture persistance;

    @GetMapping("/Adherents")
    public Collection<Adherent> GetAllAdherents(){
        return persistance.getAdherents();
    }


    public static void main (String[] args){
        SpringApplication.run(AdherentController.class, args);
    }
}
