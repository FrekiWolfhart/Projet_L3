package controleur;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DateService {
	public LocalDate getDate() {
		return LocalDate.now();
	}

	public LocalDateTime getDateTime() {
		return LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
	}

	public LocalDate getDate(String date) {
		return LocalDate.parse(date);
	}

	public LocalDateTime getDateTime(String date) {
		return LocalDateTime.parse(date);
	}
}