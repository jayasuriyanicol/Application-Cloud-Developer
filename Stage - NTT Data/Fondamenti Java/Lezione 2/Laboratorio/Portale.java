// * Questo è l'esercizio BONUS che integra gli esercizi GestoreVoti e SimulatoreAccesso.

package Lezione_02;

public class Portale {

	public static void main(String[] args) {
		
		// ! Dati necessari al fine dello sviluppo della logica di autenticazione
        Integer pinCorretto = 1234;
        String ruolo = "admin";
        Integer pinInserito = 1234;
    
        int maxTentativi = 3;
        int tentativoCorrente = 1;
        boolean accesso = false;
        
        
        // ! Voti inseriti come variabili una per una per poter svolgere la logica 
        double voti1 = 10.0;
        double voti2 = 8.0;
        double voti3 = 5.0;
        double voti4 = 7.0;
        double voti5 = 9.0;
        
        
        double media = (voti1 + voti2 + voti3 + voti4 + voti5) / 5;
        
        
        
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
                
                
               
                
                // Per determinare il MAX e il MIN senza l'ausilio della libreria .math procedo con prendere
                // un voto come riferimento e procedo a confrontarlo uno ad uno con i voti restanti
                
                double votoAlto = voti1;
                if (voti2 > votoAlto) votoAlto = voti2;
                if (voti3 > votoAlto) votoAlto = voti3;
                if (voti4 > votoAlto) votoAlto = voti4;
                if (voti5 > votoAlto) votoAlto = voti5;
                
              
                double votoBasso = voti1;
                if (voti2 < votoBasso) votoBasso = voti2;
                if (voti3 < votoBasso) votoBasso = voti3;
                if (voti4 < votoBasso) votoBasso = voti4;
                if (voti5 < votoBasso) votoBasso = voti5;

                String esitoMedia;
                
                if (media < 0 || media > 10) {
                	
                    esitoMedia = "VOTO NON VALIDO";
                } else if (media < 6.0) {
                	
                    esitoMedia = "INSUFFICIENTE";
                } else if (media < 7.0) {
                	
                    esitoMedia = "SUFFICIENTE";
                } else if (media < 9.0) {
                	
                    esitoMedia = "BUONO";
                } else {
                	
                    esitoMedia = "OTTIMO";
                }
                
                System.out.println("Media: " + media + " (" + esitoMedia + ")");
                System.out.println("Voto più alto: " + votoAlto);
                System.out.println("Voto più basso: " + votoBasso);
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