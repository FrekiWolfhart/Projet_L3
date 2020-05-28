package restful;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import controleur.PersistanceServiceLecture;
import modele.Oeuvre;

@RestController
@SpringBootApplication
@ComponentScan("controleur.implementation")
public class AuteurController {

	@Autowired
	private PersistanceServiceLecture lecture;

	@GetMapping("/auteurs")
	public Collection<String> getAllAuteurs() {
		return lecture.getAuteurs();
	}

	@GetMapping("/auteurs/{nom}")
	public Collection<Oeuvre> getOeuvresByAuteur(@PathVariable String nom) {
		return lecture.getAuteur(nom);
	}
}
