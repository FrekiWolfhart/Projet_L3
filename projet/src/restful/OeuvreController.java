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
public class OeuvreController {
    @Autowired
    private PersistanceServiceLecture persistance;

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

}
