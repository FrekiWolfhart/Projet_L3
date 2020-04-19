package controleur;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ServicesFormatageDate {

	DateTimeFormatter dateFormatter;

	DateTimeFormatter heureFormatter;
	
	DateTimeFormatter dateHeureFormatter;

	public ServicesFormatageDate() {
		String date = "dd MMMM yyyy";
		String heure = "HH'h'mm";
		dateFormatter = DateTimeFormatter.ofPattern(date);
		heureFormatter = DateTimeFormatter.ofPattern(heure);
		dateHeureFormatter = DateTimeFormatter.ofPattern(date + " 'à' " + heure);
	}

	/**
	 * exemple : 17 avril 2020
	 */
	public String toStringDate(TemporalAccessor date) {
		return toString(dateFormatter, date);
	}

	/**
	 * exemple : 11h21
	 */
	public String toStringHeure(TemporalAccessor heure) {
		return toString(heureFormatter, heure);
	}
	/**
	 * exemple : 17 avril 2020 à 11h21
	 */
	public String toStringdateHeure(TemporalAccessor date) {
		return toString(dateHeureFormatter, date);
	}
	
	private static String toString(DateTimeFormatter formatteur, TemporalAccessor date) {
		return date == null ? null : formatteur.format(date);
	}
}