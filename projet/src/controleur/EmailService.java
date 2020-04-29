package controleur;

import modele.Adherent;

public interface EmailService {
	public void envoyerEmailRetardataires();

	public void envoyerEmailRetardataire(Adherent adherent);

	public void envoyerEmail(Adherent adherent, String contenu);
}
