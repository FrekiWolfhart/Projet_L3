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
public class TagController {
	@Autowired
	private PersistanceServiceLecture lecture;

	@GetMapping("/Tags")
	public Collection<String> getAllTags() {
		return lecture.getTags();
	}

	@GetMapping("/Tags/{tag}")
	public Collection<Oeuvre> getOuevresByTag(@PathVariable String tag) {
		return lecture.getTag(tag);
	}

}
