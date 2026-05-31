package testCartoleria;
import static org.junit.jupiter.api.Assertions.*;
import Cartoleria2.Privato;
import org.junit.jupiter.api.Test;

/* 
    * JUnit & Mock Test - clientePrivatoTest
    ? Testing the class clientePrivatoTest with JUnit, in according to the classes given:
    
    ! pagaOK(): Executes the paga() method with a valid amount (99.0) and uses an assertion to verify that the remaining cash balance correctly matches the expected residual value (1.0).

    ! pagaSottoZero(): Executes a payment with an amount exceeding the initial balance (101.0) and uses assertFalse to verify that the resulting cash balance is not positive, effectively checking that the balance allowed to drop below zero.
*/

public class clientePrivatoTest {
	
	private Privato privato = new Privato("Cristiano", 100.0);
	
	
	@Test
	public void pagaOK() {
		
		privato.paga(99.0);
		assertEquals(1.0, privato.getCash());
	}
	
	
	@Test 
	public void pagaSottoZero() {
		
		privato.paga(101.0);
		//Or we can create -> assertFalse(privato.getCash() < 0). response = Failure
		assertFalse(privato.getCash() > 0);
		
	}

	
	
	

}
