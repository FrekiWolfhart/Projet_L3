package controleur;

import modele.Adherent;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.Pret;

public interface NouvelEmpruntService {
	public Pret emprunter(int idAdherent, String coteOeuvre, int numeroExemplaire);

	public Pret emprunter(Adherent adherent, Exemplaire exemplaire);

	public Pret emprunter(int idAdherent, String coteOeuvre);

	public Pret emprunter(Adherent adherent, Oeuvre oeuvre);
}