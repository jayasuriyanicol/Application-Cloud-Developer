package testCartoleria;
import static org.junit.jupiter.api.Assertions.*;
import Cartoleria2.Azienda; 
import org.junit.jupiter.api.Test;


/* 
    * JUnit & Mock Test - clienteAziendaTest
    ? Testing the class clienteAziendaTest with JUnit, in according to the classes given:
    
    ! SaldoOK(): Verifies via assertion that the initial account balance returned by the getter matches the expected value initialized in the setup (100.0).

    ! SaldoInseritoOK(): Updates the account balance using the setter method and asserts that the retrieved value matches the newly set amount (120.0).

    ! SaldoPaga(): Executes the paga() method with a specific amount and asserts that the remaining balance is correct (89.0), verifying that the deduction includes the 10% commission logic specific to the Azienda class.


*/
public class clienteAziendaTest {
	
	private Azienda azienda = new Azienda("Reenbac", 100.0);
	
	
	@Test
	public void SaldoOK () {
		
		assertEquals(100.0, azienda.getSaldoCc());
	}
	
	
	@Test 
	public void SaldoInseritoOK() {
		
		azienda.setSaldoCc(120.0);
		
		assertEquals(120.0, azienda.getSaldoCc() );
	}
	
	
	@Test 
	public void SaldoPaga() {
		
		azienda.paga(10);
		
		assertEquals(89,azienda.getSaldoCc());
	}
	
	

}