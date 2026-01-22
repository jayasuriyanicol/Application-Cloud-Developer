package testEsempioStringa;
import eserciziLezione14.EsempioStringa;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;



/*  
    * JUnit - Testing EsempioStringa 
    ? Creation of a simple test in the JUnit, in according testing functionalities of JUnit
    ! A. isPalindroma, checking with it if the given string 'str2' is palidroma
    ! B. contaOccorrenze, checking the count  the number of occurences 'nOccorrenze' with it
    
    ? Testing the already created function, recalling it to test it, giving us one result from:

    ! FAILUIRE | ERRORS
    ! SUCCESS

*/
class test {

    /*
      ! Giving to us an implemented method, after the creation
    */
   
	//@Test
	//void test() {
	//fail("Not yet implemented");
	//}

	@Test
	void testContaOccorrenze() {
		
		EsempioStringa es = new EsempioStringa();
		String testi = "Lorem ipsum test prova Nicol";
		int occ = 5;
		assertEquals("Il numero di occorrenze atteso è ", occ,es.contaOccorrenze(testi, "o"));
		
	}
	
	@Test
	void testIsPalidroma() {
		
		EsempioStringa es = new EsempioStringa();
		String testi = "osso";
		assertTrue("Palindroma attesa",es.isPalindroma(testi));
		
	}
}

