import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class DateTest {
	
	DateUtils d = new DateUtils();
	
	@Test
	void testGiorni() {
		
		
		LocalDate fine = LocalDate.of(2026,5,26);
		LocalDate inizio = LocalDate.of(2026, 5, 20);
		
		
		int ris = (int) d.giorniAllaScadenza(inizio, fine);
		
	
		
		assertEquals(6,ris, "ATTENZIONE ! Non è stato possibile procedere con il calcolo delle date ");
		
		
	}
	
	

	@Test
	void testGiorniFallimentare() {
		
		
		LocalDate fine = LocalDate.of(2026,5,26);
		LocalDate inizio = LocalDate.of(2026, 5, 20);
		
		
		int ris = (int) d.giorniAllaScadenza(inizio, fine);
		
	
		
		assertEquals(7,ris, "ATTENZIONE ! Non è stato possibile procedere con il calcolo delle date ");
		
		
	}
	
	

}
