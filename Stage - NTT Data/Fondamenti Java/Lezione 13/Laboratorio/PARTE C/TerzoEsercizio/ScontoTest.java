import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals; 

public class ScontoTest {
    
    ScontoService sc = new ScontoService();
    
    @Test 
    void testApplicaSconto() {
        
        double prezzoScontato = sc.applicaSconto(100.0, 0.2);
        
       
        assertEquals(80.0, prezzoScontato, 0.001, "ATTENZIONE Il calcolo dello sconto è errato!");
    }
    
    
    // Il test darà errore dato che supera la percentuale sconto prevista tra 0 e 1 
    @Test 
    void testFallimentare() {
        
        double prezzoScontato = sc.applicaSconto(100.0, 2.0);
        
       
        assertEquals(80.0, prezzoScontato, 0.001, "ATTENZIONE Il calcolo dello sconto è errato!");
    }
    
    
}
