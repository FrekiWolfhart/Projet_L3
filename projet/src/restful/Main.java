package restful;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("controleur.implementation");
        ctx.refresh();
		
//		Class<?>[] classes = {AdherentController.class, AuteurController.class, ExemplaireController.class, OeuvreController.class, PretController.class, ReservationController.class, TagController.class};
		Class<?> classes = AdherentController.class;
		SpringApplication.run(classes, args);
		
		ctx.close();
	}
}
