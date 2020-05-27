package restful;

import controleur.NouvelExemplaireService;
import controleur.PersistanceServiceEcriture;
import controleur.PersistanceServiceLecture;
import modele.Adherent;
import modele.Exemplaire;
import modele.Oeuvre;
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
    private NouvelExemplaireService nouvelExemplaireService;

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
    public Exemplaire saveExemplaireByCote(@RequestBody String cote){
        return nouvelExemplaireService.ajouterExemplaire(cote);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Exemplaire saveExemplaireByOeuvre(@RequestBody Oeuvre oeuvre){
       return nouvelExemplaireService.ajouterExemplaire(oeuvre);
    }
}
