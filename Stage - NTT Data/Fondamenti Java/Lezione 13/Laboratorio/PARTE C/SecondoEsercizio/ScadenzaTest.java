import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ScadenzaTest {
	
	ScadenzaService ss = new ScadenzaService();

	
	@Test
	void scadenzaCorretta() {
		
		LocalDate inizio = LocalDate.of(2026, 5, 10);
		LocalDate fine = LocalDate.of(2026, 5, 15);
		
		
		int giorni = ss.giorniMancanti(inizio, fine);
		
		boolean scadenza = ss.isScaduta(inizio, fine);
		
		
		assertEquals(5, giorni);
		assertFalse(scadenza);
		
	}
	
	
	@Test
	void scadenzaIncorretta() {
		
		LocalDate inizio = LocalDate.of(2026, 5, 23);
		LocalDate fine = LocalDate.of(2026, 5, 15);
		
		
		int giorni = ss.giorniMancanti(inizio, fine);
		
		boolean scadenza = ss.isScaduta(inizio, fine);
		
		//Here we give error, but using the assertTrue will give a good JUnit Test
		assertEquals(5, giorni);
		assertTrue(scadenza);
		
		
	}
}
