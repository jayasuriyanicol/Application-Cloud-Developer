package Lezione_02;

public class SimulatoreAccesso {
    
    public static void main(String [] args) {
        
        Integer pinCorretto = 1234;
        String ruolo = "admin";
        Integer pinInserito = 1234;
    
        int maxTentativi = 3;
        int tentativoCorrente = 1;
        boolean accesso = false;
        
        while(tentativoCorrente <= maxTentativi && !accesso) {
            
            System.out.println("Tentativo " + tentativoCorrente + " di " + maxTentativi);
            
            if(pinInserito.equals(pinCorretto)) {
            	
                accesso = true;
                System.out.println("SUCCESSO! Accesso effettuato.");
        
               
                switch (ruolo.toLowerCase()) {
                
                    case "admin":
                        System.out.println("Benvenuto ADMIN, siamo lieti di accoglierla a NTTData!");
                        break;
                    case "user":
                        System.out.println("Benvenuto USER, ecco i tuoi task...");
                        break;
                    case "guest":
                        System.out.println("Benvenuto GUEST, ecco la storia di NTTData.");
                        break;
                    default:
                        System.out.println("ATTENZIONE! Ruolo non riconosciuto.");
                        break;
                }
            } else {
                System.out.println("ERRORE! PIN errato.");
                tentativoCorrente++;
                
            }
        }
        
        if (!accesso) {
            System.out.println("ACCESSO NEGATO! Sistema bloccato per troppi tentativi falliti.");
        }
    }
}
