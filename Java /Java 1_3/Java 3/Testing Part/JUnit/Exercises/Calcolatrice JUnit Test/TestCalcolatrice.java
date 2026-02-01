package test;
// *import static org.junit.jupiter.api.Assertions.*  -> we can avoid inserting 'Assetions', so we can write for example -> assertEquals(2, calcolatrice.somma(1,1));;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/*  
    * JUnit - TestTamagotchi
    ? Testing the class Tamagotchi with JUnit, in according to the exercise given (prompt):
    
    ! 1. sumOK, checking if the sum is equal to the ecxpeted 
    ! 2. sumFaZero, checking if the sum is equal to zero
    ! 3. divisionOK(), checking if the division is equal to the ecxpeted
    ! 4. divisione(),checking if the divsion throws the message ZeroDivisionError, in this case a phrase
    
*/

import Calcolo.Calcolatrice;
public class TestCalcolatrice {
	
	
	// *I get the class object to test
	private Calcolatrice calcolatrice = new Calcolatrice();
	
	
	// *I add the various test methods on the calculator
	
	// ? We can verify that the test function works by right clicking -> RunAs > TestCalculator or directly by running the test
	public void sumOK() {
		
		// *After the expected output, we insert the calculation, calling the object and inserting the class attributes.
		Assertions.assertEquals(2, calcolatrice.somma(1,1));
	}
	 // ? With show stack trace (first icon next to Failure Trace, if we click it we have the stack trace of the error
	
	// ? Works, through the Test. To run the class, you're not told to create a new TestCalculator, but thanks to the @Test it allows you to automatically test it. It creates a sort of bookmark
	@Test 
	public void sumFaZero() {
		
		Assertions.assertEquals(0, calcolatrice.somma(1, -1));
	}
	
	@Test
	public void divisionOK() throws Exception{
		
		Assertions.assertEquals(2.5, calcolatrice.dividi(10, 4));
	   
	}
	
	@Test 
	public void divisione () {
		
	 Exception e = Assertions.assertThrows(Exception.class, () -> calcolatrice.dividi(10, 0));
	 Assertions.assertEquals("ATTENZIONE ! Errore divisione per zero", e.getMessage());
	
	}
}
