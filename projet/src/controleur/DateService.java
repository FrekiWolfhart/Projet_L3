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
}