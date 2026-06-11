import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtils {

	public long giorniAllaScadenza(LocalDate oggi, LocalDate scadenza) {
			if (oggi == null || scadenza == null)
				
				throw new IllegalArgumentException("ATTENZIONE ! Le date sono obbligatorie");
			
			return ChronoUnit.DAYS.between(oggi, scadenza);
			
	}
}
