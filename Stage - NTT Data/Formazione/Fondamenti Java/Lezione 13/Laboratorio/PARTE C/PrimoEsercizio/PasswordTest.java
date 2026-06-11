import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class PasswordTest {

    PasswordValidator pv = new PasswordValidator();
    
    @Test
    void Testcorretto() {
    	
        String prima = pv.verificaPassword("Bobby67");
        
        assertEquals("SUCCESSO ! La password inserita è valida", prima);
    }
    
    @Test 
    void TestScorretto() {
        
    	//In this case we manage it with a assertThrowException
    	assertThrows(IllegalArgumentException.class, () -> {
            pv.verificaPassword("camel");
        });
    }
}
