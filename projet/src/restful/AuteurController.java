package restful;


import controleur.PersistanceServiceLecture;
import modele.Oeuvre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@EnableAutoConfiguration
public class AuteurController {

    @Autowired
    private PersistanceServiceLecture persistance;

    @GetMapping("/Auteurs")
    public Collection<String> getAllAuteurs(){
        return persistance.getAuteurs();
    }

    @GetMapping("/Auteurs/{nom}")
    public Collection<Oeuvre> getOeuvresByAuteur(@PathVariable String nom){
        return persistance.getAuteur(nom);
    }
}
