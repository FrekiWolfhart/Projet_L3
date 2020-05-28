package test.java;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import controleur.NouvelAdherentService;
import controleur.PersistanceServiceLecture;

@ComponentScan("controleur.implementation")
@SpringBootApplication
public class Demonstration { // pas vraiment un test mais une démonstration

	@Autowired
	private NouvelAdherentService nouvelAdherentService;
	@Autowired
	private PersistanceServiceLecture lecture;

	public static void main(String[] args) {
		SpringApplication.run(Demonstration.class, args);
	}

	@PostConstruct
	public void init() {
		afficherAdherents();
		nouvelAdherentService.ajouterAdherent("xxx", "aaa", "ooo@gmail.com");
		afficherAdherents();
		nouvelAdherentService.ajouterAdherent("yyy", "bbb", "ppp@gmail.com");
		afficherAdherents();
		nouvelAdherentService.ajouterAdherent("zzz", "ccc", "ppp@gmail.com");
		afficherAdherents();
	}

	private void afficherAdherents() {
		System.out.println("liste des adhérents : ");
		lecture.getAdherents().forEach(System.out::println);
		System.out.println("fin de la liste des adhérents\n");
	}
}
