package Lezione_07;

import java.io.IOException;

public class MainReport {

    public static void main(String[] args) throws OrdineNonValidoException {
        
    	// ? Utilizziamo la logica in maniera elementare applicata con I/O del Publisher e Subscriber 
        OrdineReader reader = new OrdineReader();
        ReportWriter writer = new ReportWriter();
        
        String riepilogoFinale;

        try {
         
            Ordine letturaGrezza = reader.leggiOrdine();
   
            
            riepilogoFinale = letturaGrezza.riepilogo();
            System.out.println("\nSUCCESSO ! L'elaborazione è stata completata con successo.\n");
            System.out.println(riepilogoFinale);
            
            
        } catch (Exception e) {
            
        	riepilogoFinale = "\n|REPORT DI ERRORE ELABORAZIONE|\n" +
                                   "STATO -> FALLITO\n" +
                                   "\nDettaglio ERRORE: " + e.getMessage() + "\n";
            
            System.err.println("\nATTENZIONE ! Elaborazione fallita.\n");
        }

        
        try {
        	
            writer.scritturaFile(riepilogoFinale);
            
            System.out.println("\nSUCCESSO! Il file 'report-ordine.txt' è stato aggiornato.");
            
        } catch (IOException e) {
            
            System.err.println("\n[ERRORE CRITICO]: Impossibile scrivere il file di report sul disco!\nInformazioni aggiuntive:\n" + e.getMessage());
            
            
        }
    }
}
