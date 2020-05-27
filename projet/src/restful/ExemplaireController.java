package restful;

import controleur.PersistanceServiceEcriture;
import controleur.PersistanceServiceLecture;
import modele.Adherent;
import modele.Exemplaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@EnableAutoConfiguration
public class ExemplaireController {

    @Autowired
    private PersistanceServiceLecture persistance;

    @Autowired
    private PersistanceServiceEcriture persistanceServiceEcriture;

    @GetMapping("/Exemplaires")
    public Collection<Exemplaire> getAllExemplaires(){
        return persistance.getExemplaires();
    }

    @GetMapping("/Exemplaires/{cote}/{id}")
    public Exemplaire getExemplairesByCoteAndId(@PathVariable String cote, @PathVariable int id){
        return persistance.getExemplaire(cote,id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveExemplaire(@RequestBody Exemplaire exemplaire){
        persistanceServiceEcriture.enregistrer(exemplaire);
    }
}
