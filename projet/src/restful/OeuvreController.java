package restful;

import controleur.PersistanceServiceEcriture;
import controleur.PersistanceServiceLecture;
import modele.Adherent;
import modele.Oeuvre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@EnableAutoConfiguration
public class OeuvreController {
    @Autowired
    private PersistanceServiceLecture persistance;

    @Autowired
    private PersistanceServiceEcriture persistanceServiceEcriture;

    @GetMapping("/Oeuvres")
    public Collection<Oeuvre> getAllOeuvres(){
        return persistance.getOeuvres();
    }

    @GetMapping("/Oeuvres/{cote}")
    public Oeuvre getOeuvreByCote(@PathVariable String cote){
        return persistance.getOeuvre(cote);
    }

    @GetMapping("/Oeuvres/{titre}")
    public Collection<Oeuvre> getOeuvreByTitle(@PathVariable String titre){
        return persistance.getOeuvres(titre);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOeuvre(@RequestBody Oeuvre oeuvre){
        persistanceServiceEcriture.enregistrer(oeuvre);
    }

}
