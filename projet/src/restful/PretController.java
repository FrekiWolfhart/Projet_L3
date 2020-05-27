package restful;

import controleur.PersistanceServiceLecture;
import modele.Pret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@EnableAutoConfiguration
public class PretController {
    @Autowired
    private PersistanceServiceLecture persistance;

    @GetMapping("/Prets")
    public Collection<Pret> getAllPrets(){
        return persistance.getPrets();
    }

    @GetMapping("/Retards")
    public Collection<Pret> getPretsEnRetards(){
        return persistance.getPretsEnRetard();
    }



}
