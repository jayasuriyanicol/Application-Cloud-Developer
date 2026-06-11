import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ScadenzaService {
	
	
	
	public int giorniMancanti(LocalDate inizio, LocalDate fine) {
		
		
		if(inizio == null  || fine == null) {
			throw new IllegalArgumentException("ATTENZIONE ! Le date devono essere coerenti !");
			
		}
		
		return (int) ChronoUnit.DAYS.between(inizio, fine);
		
		
	}
	
	
	public Boolean isScaduta(LocalDate inizio, LocalDate fine) {
		
		return giorniMancanti(inizio, fine) < 0;
				
		
		
	}
}
