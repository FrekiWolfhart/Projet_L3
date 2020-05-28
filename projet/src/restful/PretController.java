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

import controleur.NouvelEmpruntService;
import controleur.PersistanceServiceLecture;
import modele.Pret;

@RestController
@SpringBootApplication
@ComponentScan("controleur.implementation")
public class PretController {
	@Autowired
	private PersistanceServiceLecture lecture;

	@Autowired
	private NouvelEmpruntService nouvelEmpruntService;

	@GetMapping("/prets")
	public Collection<Pret> getAllPrets() {
		return lecture.getPrets();
	}

	@GetMapping("/prets/{numero}")
	public Pret getPretByNumero(@PathVariable int numero) {
		return lecture.getPret(numero);
	}

	@GetMapping("/retards")
	public Collection<Pret> getPretsEnRetards() {
		return lecture.getPretsEnRetard();
	}

	@PostMapping("emprunter")
	@ResponseStatus(HttpStatus.CREATED)
	public Pret savePret(@RequestBody int idAdherent, @RequestBody String coteOeuvre, @RequestBody int numeroExemplaire) {
		return nouvelEmpruntService.emprunter(idAdherent, coteOeuvre, numeroExemplaire);
	}

//	@PostMapping("emprunter")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Pret savePret(@RequestBody Adherent adherent, @RequestBody Exemplaire exemplaire) {
//		return nouvelEmpruntService.emprunter(adherent, exemplaire);
//	}

//	@PostMapping("emprunterUnExemplaire")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Pret savePret(@RequestBody int idAdherent, @RequestBody String coteOeuvre) {
//		return nouvelEmpruntService.emprunter(idAdherent, coteOeuvre);
//	}
//
//	@PostMapping("emprunter")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Pret savePret(@RequestBody Adherent adherent, @RequestBody Oeuvre oeuvre) {
//		return nouvelEmpruntService.emprunter(adherent, oeuvre);
//	}

}
