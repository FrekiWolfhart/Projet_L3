package controleur;

import java.time.LocalDateTime;

import modele.Pret;

public interface ProlongationEmpruntService {
	public boolean prolonger(String coteOeuvre, int numeroExemplaire, int idEmprunteur, String dateEmprunt);

	public boolean prolonger(String coteOeuvre, int numeroExemplaire, int idEmprunteur, LocalDateTime dateEmprunt);

	public boolean prolonger(Pret pret);
}
