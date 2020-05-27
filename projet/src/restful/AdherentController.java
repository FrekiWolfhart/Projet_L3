package restful;

import controleur.PersistanceServiceEcriture;
import controleur.PersistanceServiceLecture;
import controleur.implementation.PersistanceImplement;
import modele.Adherent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Collection<Adherent> getAllAdherents(){
        return persistance.getAdherents();
    }

    @GetMapping("/Adherents/{id}")
    public Adherent getAdherentById(@PathVariable int id){
        return persistance.getAdherent(id);
    }


    public static void main (String[] args){
        SpringApplication.run(AdherentController.class, args);
    }
}
