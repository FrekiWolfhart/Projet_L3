package restful;

import org.springframework.boot.SpringApplication;

public class Main {
	public static void main(String[] args) {

//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		ctx.scan("controleur", "controleur.implementation");
//		ctx.refresh();

//		System.out.println(ctx.getBean(PersistanceServiceLecture.class).getAdherent(1));
		Class<?>[] classes = {AdherentController.class, AuteurController.class, ExemplaireController.class, OeuvreController.class, PretController.class, ReservationController.class, TagController.class};
//		Class<?> classes = AuteurController.class;//AuteurController.class;// AdherentController.class;
		SpringApplication.run(classes, args);
//		
//		ctx.close();
	}
}
