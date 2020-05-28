package controleur.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controleur.DateService;
import controleur.PersistanceServiceEcriture;
import controleur.PersistanceServiceLecture;
import controleur.ReservationService;
import controleur.MyCollectionUtils;
import modele.Adherent;
import modele.Oeuvre;
import modele.Reservation;
import modele.primaryKeys.ReservationPK;

@Service("reservationService")
public class ReservationServiceImplement implements ReservationService {

	@Autowired
	private PersistanceServiceEcriture ecriture;

	@Autowired
	private PersistanceServiceLecture lecture;

	@Override
	public Reservation reserver(int idAdherent, String coteOeuvre) {
		Adherent adherent = lecture.getAdherent(idAdherent);

		if (adherent == null) {
			// TODO
		}

		Oeuvre oeuvre = lecture.getOeuvre(coteOeuvre);

		if (oeuvre == null) {
			// TODO
		}

		return reserver(adherent, oeuvre);
	}

	@Override
	public Reservation reserver(Adherent adherent, Oeuvre oeuvre) {
		Reservation reservation = MyCollectionUtils.stream(adherent.getReservations()).filter(reserv -> reserv.getOeuvre().equals(oeuvre)).findAny()
				.orElse(null); // TODO : faire ça proprement coté BDD

		if (reservation != null) { // si cet adhérent a déjà réservé cette oeuvre
			return reservation;
		}

		reservation = new Reservation().setId(new ReservationPK(adherent, oeuvre)).setDateReservation(DateService.getDateTime());

		ecriture.enregistrer(reservation);

		return reservation;
	}
}