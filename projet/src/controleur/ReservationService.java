package controleur;

import modele.Adherent;
import modele.Oeuvre;
import modele.Reservation;

public interface ReservationService {
	public Reservation reserver(int idAdherent, String coteOeuvre);

	public Reservation reserver(Adherent adherent, Oeuvre oeuvre);
}
