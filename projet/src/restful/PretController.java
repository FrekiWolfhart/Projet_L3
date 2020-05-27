package restful;

import controleur.NouvelEmpruntService;
import controleur.PersistanceServiceLecture;
import modele.Adherent;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.Pret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@EnableAutoConfiguration
public class PretController {
    @Autowired
    private PersistanceServiceLecture persistance;

    @Autowired
    NouvelEmpruntService empruntService;

    @GetMapping("/Prets")
    public Collection<Pret> getAllPrets(){
        return persistance.getPrets();
    }

    @GetMapping("/Prets/{numero}")
    public Pret getPretByNumero(@PathVariable int numero){
        return persistance.getPret(numero);
    }

    @GetMapping("/Retards")
    public Collection<Pret> getPretsEnRetards(){
        return persistance.getPretsEnRetard();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pret savePret(@RequestBody int idAdherent,@RequestBody String coteOeuvre,@RequestBody int numeroExemplaire){
        return empruntService.emprunter(idAdherent,coteOeuvre,numeroExemplaire);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pret savePret(@RequestBody Adherent adherent, @RequestBody Exemplaire exemplaire){
        return empruntService.emprunter(adherent,exemplaire);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pret savePret(@RequestBody int idAdherent,@RequestBody String coteOeuvre){
        return empruntService.emprunter(idAdherent,coteOeuvre);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pret savePret(@RequestBody Adherent adherent,@RequestBody Oeuvre oeuvre){
        return empruntService.emprunter(adherent,oeuvre);
    }



}
