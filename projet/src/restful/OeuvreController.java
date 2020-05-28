package restful;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import controleur.NouvelleOeuvreService;
import controleur.PersistanceServiceLecture;
import modele.Oeuvre;

@RestController
@SpringBootApplication
@ComponentScan("controleur.implementation")
public class OeuvreController {
	@Autowired
	private PersistanceServiceLecture lecture;

	@Autowired
	private NouvelleOeuvreService nouvelleOeuvreService;

	@GetMapping("/oeuvres")
	public Collection<Oeuvre> getAllOeuvres() {
		return lecture.getOeuvres();
	}

	@GetMapping("/oeuvres/{cote}")
	public Oeuvre getOeuvreByCote(@PathVariable String cote) {
		return lecture.getOeuvre(cote);
	}

	@GetMapping("/oeuvres/byTitle/{titre}")
	public Collection<Oeuvre> getOeuvreByTitle(@PathVariable String titre) {
		return lecture.getOeuvres(titre);
	}

	@PostMapping("ajouterOeuvre")
	@ResponseStatus(HttpStatus.CREATED)
	public Oeuvre saveOeuvre(@RequestBody String cote, @RequestBody String titre, @RequestBody String dateSortie, @RequestBody Collection<String> auteurs,
			@RequestBody Collection<String> tags) {
		return nouvelleOeuvreService.ajouterOeuvre(cote, titre, dateSortie, auteurs, tags);
	}
}
