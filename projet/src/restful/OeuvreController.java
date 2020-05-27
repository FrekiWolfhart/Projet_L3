package restful;

import controleur.NouvelleOeuvreService;
import controleur.PersistanceServiceEcriture;
import controleur.PersistanceServiceLecture;
import modele.Adherent;
import modele.Oeuvre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;

@RestController
@EnableAutoConfiguration
public class OeuvreController {
    @Autowired
    private PersistanceServiceLecture persistance;

    @Autowired
    private NouvelleOeuvreService nouvelleOeuvreService;

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
    public Oeuvre saveOeuvre(@RequestBody String cote ,@RequestBody String titre,@RequestBody String dateSortie,@RequestBody Collection<String> auteurs,@RequestBody Collection<String> tags ){
        return nouvelleOeuvreService.ajouterOeuvre(cote,titre,dateSortie,auteurs,tags);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Oeuvre saveOeuvre(@RequestBody String cote,@RequestBody String titre,@RequestBody LocalDate dateSortie,@RequestBody Collection<String> auteurs,@RequestBody Collection<String> tags ){
        return nouvelleOeuvreService.ajouterOeuvre(cote,titre,dateSortie,auteurs,tags);
    }

}
