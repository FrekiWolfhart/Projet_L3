package controleur;

import java.time.temporal.Temporal;

import modele.Pret;

public interface ProlongationEmpruntService {
	public boolean prolonger(String coteOeuvre, int numeroExemplaire, int idEmprunteur, String dateEmprunt);

	public boolean prolonger(String coteOeuvre, int numeroExemplaire, int idEmprunteur, Temporal dateEmprunt);

	public boolean prolonger(Pret pret);
}
