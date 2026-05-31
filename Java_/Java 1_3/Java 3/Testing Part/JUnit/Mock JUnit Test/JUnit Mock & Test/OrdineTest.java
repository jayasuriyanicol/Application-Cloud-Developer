package testCartoleria;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import Cartoleria2.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

/* 
    * JUnit & Mock Test - OrdineTest
    ? Testing the class OrdineTest with JUnit, in according to the classes given:
    
    ! gestioneOrdine(): Populates the order with mock articles, executes the chiudi() method to finalize the transaction, asserts that the order status is successfully marked as paid, and uses Mockito to verify that the paga() method was invoked on the mock client with any double value.

*/


@ExtendWith(MockitoExtension.class)
public class OrdineTest {
	
		@Mock
		private Cliente client  = new Privato("Nicolas",100.0);
		
		
		@Mock 
		private Penne p1 = new Penne("Stabilo", "SferaTergi", 1.20,  "Blu");
		
		@Mock 
		private Penne p2 = new Penne("BIC", "Ultimate", 1.50,  "Nera");
		
		
		@Mock 
		private Gomme g1 = new Gomme("FlashPormi", "ElasticFiber", 1.00,  "Quadrata", 0.08);
		
		
		@Mock 
		private Gomme g2 = new Gomme("Hargithon", "TotalWhite", 2.10,  "Quadrata", 0.40);
		
		@InjectMocks
		
		private Ordine ord1 = new Ordine(LocalDate.now(),client);
		
		@Test
		
		public void gestioneOrdine() {
			
			
			ord1.carica(p1);
			ord1.carica(p2);
			ord1.carica(g1);
			
			//ACT
			ord1.chiudi();
			
			
			assertTrue(ord1.isPagato());
			
			verify(client).paga(anyDouble());
			
			
		}


}
