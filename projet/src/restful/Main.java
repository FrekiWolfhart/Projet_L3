package restful;

import org.springframework.boot.SpringApplication;

public class Main {
	public static void main(String[] args) {

		Class<?>[] classes = { AdherentController.class, AuteurController.class, ExemplaireController.class, OeuvreController.class, PretController.class,
				ReservationController.class, TagController.class };
		SpringApplication.run(classes, args);

	}
}
