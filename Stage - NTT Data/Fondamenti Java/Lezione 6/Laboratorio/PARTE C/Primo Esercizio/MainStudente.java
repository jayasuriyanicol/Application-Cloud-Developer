package Lezione_06;

public class MainStudente {

    public static void main(String[] args) {
        
        try {
        
            StudenteDTO s1 = new StudenteDTO("MARIO", "CARLO", 28.5);
            StudenteDTO s2 = new StudenteDTO("CRIS", "ATTA", 15.0);
           
            analizzaStudente(s1);

           
            analizzaStudente(s2);
            
           
            System.out.println("|TEST ERRORE|");
            StudenteDTO s3 = new StudenteDTO("Errore", "Test", 35.0);

        } catch (IllegalArgumentException e) {
        	
            System.err.println(e.getMessage());
        }
    }

    public static void analizzaStudente(StudenteDTO studente) {
    	
        System.out.println("STUDENTE: " + studente.nome() + " " + studente.cognome());
        System.out.println("MEDIA: " + studente.media());

      
        if (studente.isPromosso()) {
            
            LivelloStudente livello = determinaLivello(studente.media());
            
            System.out.println("Stato: PROMOSSO");
            
            System.out.println("Livello: " + livello + " -> " + livello.descrizione());
            
        } else {
        	
            System.out.println("Stato: NON PROMOSSO");
        }
    }

        public static LivelloStudente determinaLivello(Double media) {
        	
        if (media >= 27) return LivelloStudente.AVANZATO;
        if (media >= 22) return LivelloStudente.INTERMEDIO;
        
        return LivelloStudente.JUNIOR;
    }
}
