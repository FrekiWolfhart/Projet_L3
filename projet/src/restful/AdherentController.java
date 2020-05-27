package restful;

import controleur.PersistanceServiceEcriture;
import controleur.PersistanceServiceLecture;
import controleur.implementation.PersistanceImplement;
import modele.Adherent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@EnableAutoConfiguration
public class AdherentController {

    @Autowired
    private PersistanceServiceLecture persistance;

    @Autowired
    private PersistanceServiceEcriture persistanceServiceEcriture;

    @GetMapping("/Adherents")
    public Collection<Adherent> getAllAdherents(){
        return persistance.getAdherents();
    }

    @GetMapping("/Adherents/{id}")
    public Adherent getAdherentById(@PathVariable int id){
        return persistance.getAdherent(id);
    }

    @GetMapping("/Adherents/{email}")
    public Collection<Adherent> getAllAdherents(@PathVariable String email){
        return persistance.getAdherents(email);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAdherent(@RequestBody Adherent adherent){
        persistanceServiceEcriture.enregistrer(adherent);
    }



    public static void main (String[] args){
        SpringApplication.run(AdherentController.class, args);
    }
}
