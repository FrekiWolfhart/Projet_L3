package restful;

import java.time.LocalDate;
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

import controleur.NouvelleOeuvreService;
import controleur.PersistanceServiceLecture;
import modele.Oeuvre;

@RestController
@EnableAutoConfiguration
public class OeuvreController {
	@Autowired
	private PersistanceServiceLecture lecture;

	@Autowired
	private NouvelleOeuvreService nouvelleOeuvreService;

	@GetMapping("/Oeuvres")
	public Collection<Oeuvre> getAllOeuvres() {
		return lecture.getOeuvres();
	}

	@GetMapping("/Oeuvres/{cote}")
	public Oeuvre getOeuvreByCote(@PathVariable String cote) {
		return lecture.getOeuvre(cote);
	}

	@GetMapping("/Oeuvres/{titre}")
	public Collection<Oeuvre> getOeuvreByTitle(@PathVariable String titre) {
		return lecture.getOeuvres(titre);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Oeuvre saveOeuvre(@RequestBody String cote, @RequestBody String titre, @RequestBody String dateSortie, @RequestBody Collection<String> auteurs,
			@RequestBody Collection<String> tags) {
		return nouvelleOeuvreService.ajouterOeuvre(cote, titre, dateSortie, auteurs, tags);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Oeuvre saveOeuvre(@RequestBody String cote, @RequestBody String titre, @RequestBody LocalDate dateSortie, @RequestBody Collection<String> auteurs,
			@RequestBody Collection<String> tags) {
		return nouvelleOeuvreService.ajouterOeuvre(cote, titre, dateSortie, auteurs, tags);
	}

}
