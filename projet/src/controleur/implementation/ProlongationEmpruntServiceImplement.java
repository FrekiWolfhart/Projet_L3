package controleur.implementation;

import java.time.temporal.Temporal;

import controleur.ProlongationEmpruntService;
import modele.Pret;

public class ProlongationEmpruntServiceImplement implements ProlongationEmpruntService {

	@Override
	public boolean prolonger(String coteOeuvre, int numeroExemplaire, int idEmprunteur, String dateEmprunt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean prolonger(String coteOeuvre, int numeroExemplaire, int idEmprunteur, Temporal dateEmprunt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean prolonger(Pret pret) {
		// TODO Auto-generated method stub
		return false;
	}

}
