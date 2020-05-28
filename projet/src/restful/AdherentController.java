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

import controleur.NouvelAdherentService;
import controleur.PersistanceServiceLecture;
import modele.Adherent;

@RestController
@SpringBootApplication
@ComponentScan("controleur.implementation")
public class AdherentController {

	@Autowired
	private PersistanceServiceLecture lecture;

	@Autowired
	private NouvelAdherentService nouvelAdherentService;

	@GetMapping("/adherents")
	public Collection<Adherent> getAllAdherents() {
		return lecture.getAdherents();
	}

	@GetMapping("/adherents/{id}")
	public Adherent getAdherentById(@PathVariable int id) {
		return lecture.getAdherent(id);
	}

	@GetMapping("/adherents/byEmail/{email}")
	public Collection<Adherent> getAllAdherents(@PathVariable String email) {
		return lecture.getAdherents(email);
	}

	@PostMapping("enregistrerAdherent")
	@ResponseStatus(HttpStatus.CREATED)
	public Adherent saveAdherent(@RequestBody String nom, @RequestBody String prenom, @RequestBody String email) {
		return nouvelAdherentService.ajouterAdherent(nom, prenom, email);
	}
}