package controleur;

import java.util.Collection;

import modele.Adherent;
import modele.Pret;

public interface EmailService {
	public void envoyerEmailRetardataires();

	void envoyerEmailRetardataire(Adherent adherent, Collection<Pret> pretsEnRetard);

	public void envoyerEmail(Adherent adherent, String contenu);
}
