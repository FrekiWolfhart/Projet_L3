package restful;

import controleur.PersistanceServiceLecture;
import modele.Exemplaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@EnableAutoConfiguration
public class ExemplaireController {

    @Autowired
    private PersistanceServiceLecture persistance;

    @GetMapping("/Exemplaires")
    public Collection<Exemplaire> getAllExemplaires(){
        return persistance.getExemplaires();
    }

    @GetMapping("/Exemplaires/{cote}/{id}")
    public Exemplaire getExemplairesByCoteAndId(@PathVariable String cote, @PathVariable int id){
        return persistance.getExemplaire(cote,id);
    }
}
