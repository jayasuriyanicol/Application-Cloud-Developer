package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Calcolo.Tamagotchi;



/*  
    * JUnit - TestTamagotchi
    ? Testing the class Tamagotchi with JUnit, in according to the exercise given (prompt):
    
    ! 1. testCostruttoreInizializzaValoriCorretti(), checking if name and specie are correct 
    ! 2. testNomeNonModificabile(), checking if name is not possible to modify -> because final
    ! 3. testSpecieNonModificabile(), checking if name is not possible to modify -> because final
    ! 4. testMangia(), checking if energy is sufficient to eat 
    ! 5. testGiocaZeroEnergie(), checking the impossibility of play because zero energy
    ! 6. testGiocaPesoMinimo(), checking the impossibility of play the weight not under 0 (negative)
    ! 7. testSequenzaOperazioni(), sequence of operation with the sum of all one, excpeted to the output


*/

public class TestTamagotchi {
	
	
	
	// Test di creazione oggetto testCostruttoreInizializzaValoriCorretti() nome e specie assegnati correttamente peso, altezza, energia inizializzati ai valori previsti
	@Test 
	public void testCostruttoreInizializzaValoriCorretti() {
		
		Tamagotchi t2 = new Tamagotchi("Cristiano", "Canarino");
		
		assertEquals("Cristiano", t2.getNome());
		assertEquals("Canarino", t2.getSpecie());
		
		
	}
	
	
	//⃣ testNomeNonModificabile()   

	@Test 
	public void testNomeNonModificabile() {
		
		String nomeInserito = "Dario";
		
		Tamagotchi t3 = new Tamagotchi(nomeInserito, "Cristiano");
		
		assertEquals(nomeInserito, t3.getNome());

		
	}
	
	// testSpecieNonModificabile()
	
	
	@Test 
	public void testSpecieNonModificabile() {
		
		String specieInserita = "coniglio";
		String specieAttesa = "Coniglio";
		
		Tamagotchi t3 = new Tamagotchi("Dario", specieInserita);
		
		assertEquals(specieAttesa, t3.getSpecie());
		
		
	
	}
	
	
	
	//Test metodo mangia()
	

	@Test
	public void testMangia() {
		
		Tamagotchi t = new Tamagotchi("Giacomo", "cane");
		

		boolean haMangiato = t.mangia();
		
		
		assertTrue(haMangiato);

		assertEquals( 21.0, t.getAltezza());
	
		assertEquals(450.0, t.getPeso());
	
		assertEquals( 4, t.getEnergia());
	}
	
	
 // testGiocaEnergiaZero() 
	
	
	@Test
	public void testGiocaEnergiaZero() {
		
		Tamagotchi t = new Tamagotchi("Giacomo", "cane");
		
		t.gioca();
		t.gioca();
		
		assertFalse(t.gioca());
	
		assertEquals(1, t.getEnergia());
		
		
	}

 // testGiocaPesoMinimo()

	@Test 
	public void testGiocaPesoMinimo() {
		
		
		Tamagotchi t = new Tamagotchi("Giacomo", "cane");
		
		t.gioca();
		t.gioca();
		
		assertFalse(t.gioca());
		
		assertEquals(100, t.getPeso());
			
		
	}
	

	//⃣ Test sequenza operazioni (test di integrazione) 
	
	@Test 
	public void testSequenzaOperazioni() {
		
		Tamagotchi t = new Tamagotchi("Giacomo", "cane");
		
		t.mangia();
		t.dorme();
		t.gioca();
		
		Double somma = 0.0;
		
		somma += t.getPeso();
		somma += t.getEnergia();
		
	
		assertEquals(354.0, somma);
		
		
		
		
		
	}
	
	
	
	
	
	

}
