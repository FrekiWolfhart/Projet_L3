package restful;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import controleur.PersistanceServiceLecture;
import modele.Oeuvre;

@RestController
@EnableAutoConfiguration
public class AuteurController {

	@Autowired
	private PersistanceServiceLecture lecture;

	@GetMapping("/Auteurs")
	public Collection<String> getAllAuteurs() {
		return lecture.getAuteurs();
	}

	@GetMapping("/Auteurs/{nom}")
	public Collection<Oeuvre> getOeuvresByAuteur(@PathVariable String nom) {
		return lecture.getAuteur(nom);
	}
}
