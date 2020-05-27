package restful;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import controleur.NouvelExemplaireService;
import controleur.PersistanceServiceLecture;
import modele.Exemplaire;
import modele.Oeuvre;

@RestController
@EnableAutoConfiguration
public class ExemplaireController {

	@Autowired
	private PersistanceServiceLecture lecture;

	@Autowired
	private NouvelExemplaireService nouvelExemplaireService;

	@GetMapping("/Exemplaires")
	public Collection<Exemplaire> getAllExemplaires() {
		return lecture.getExemplaires();
	}

	@GetMapping("/Exemplaires/{cote}/{id}")
	public Exemplaire getExemplairesByCoteAndId(@PathVariable String cote, @PathVariable int id) {
		return lecture.getExemplaire(cote, id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Exemplaire saveExemplaireByCote(@RequestBody String cote) {
		return nouvelExemplaireService.ajouterExemplaire(cote);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Exemplaire saveExemplaireByOeuvre(@RequestBody Oeuvre oeuvre) {
		return nouvelExemplaireService.ajouterExemplaire(oeuvre);
	}
}
