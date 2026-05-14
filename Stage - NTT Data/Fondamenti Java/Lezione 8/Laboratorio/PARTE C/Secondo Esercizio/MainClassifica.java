package Lezione_07;

public class MainClassifica {

    public static void main(String[] args) {
        

        Classifica gestioneClassifica = new Classifica();

        
        Giocatore g1 = new Giocatore("Francesco", "Toti", "Attaccante", "25", "FR10RFHSRSQEAEF");
        Giocatore g2 = new Giocatore("Leandro", "PazienteComeNonMai", "Centrocampista", "28", "LADA3Q3QMSKJKSNFD");
        Giocatore g3 = new Giocatore("Anna", "Bianchi", "Difensore", "23", "BNCNNA03C43H501Y");

     
        gestioneClassifica.aggiuntaGiocatore(g1);
        gestioneClassifica.aggiuntaGiocatore(g2);
        gestioneClassifica.aggiuntaGiocatore(g3);
        
        System.out.println("\n|TEST DUPLICATO|");
        gestioneClassifica.aggiuntaGiocatore(g1);

        System.out.println("\n|CONTROLLO ESISTENZA|");
       
        String cfDaCercare = "BNCNNA03C43H501Y";
        if (gestioneClassifica.controlloEsistenzaGiocatore(cfDaCercare)) {
        	
            System.out.println("Il giocatore con CF " + cfDaCercare + " esiste.");
            
        } else {
            System.out.println("Il giocatore con CF " + cfDaCercare + " NON esiste.");
        }


      
        gestioneClassifica.aggiornamentoPunteggio("FR10RFHSRSQEAEF", 10); 
        gestioneClassifica.aggiornamentoPunteggio("LADA3Q3QMSKJKSNFD", 15); 
        gestioneClassifica.aggiornamentoPunteggio("BNCNNA03C43H501Y", 5); 
        
       
        gestioneClassifica.aggiornamentoPunteggio("CF_ERRATO_123456", 20);

       
        gestioneClassifica.stampaClassifica();
    }
}
