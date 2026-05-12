package Lezione_06;

public class MainEsitoOperazione {

    public static void main(String[] args) {
        
        try {
            
        	// 1. ProdottoDTO
            ProdottoDTO p1 = new ProdottoDTO("Smartphone", 599.90);
            CategoriaProdotto cat = CategoriaProdotto.NUOVO;

            // 2. SEALED CLASS
            EsitoOperazione risultato = salvaProdotto(p1, cat);
            
            // 3. ESITO OPERAZIONE
            String messaggioFinale = switch (risultato) {
                case Successo s -> "SUCCESSO ! " + s.getMessaggio();
                case Errore e   -> "ATTENZIONE !\nERRORE: " + e.getMotivazioneErrore();
                
                //OPPURE :
                
                /*
                 *  if(esito instanceof Successo s) {
		 
		 				System.out.println("ESITO: " + s.getMessaggio());
		 
	 				}else if(errore instanceof Errore err) {
		 
		 				System.out.println("ERRORE: "+ err.getMotivazioneErrore());
	 				}
                 * 
                 */
                
            };

            System.out.println(messaggioFinale);

           // 4. Gestione ERRORE PRODOTTO
        } catch (IllegalArgumentException e) {
            
            System.err.println("ATTENZIONE ! Errore nella creazione del PRODOTTO\nERRORE: " + e.getMessage());
        }
    }

   
    public static EsitoOperazione salvaProdotto(ProdottoDTO p, CategoriaProdotto c) {
    	
        if (p.prezzo() > 1000) {
            return new Errore("ATTENZIONE ! Budget superato per la categoria " + c.name());
        }
        return new Successo("PRODOTTO -> " + p.nome() + "\nDESCRIZIONE: " + c.descrizione() + "\nsalvato con SUCCESSO!");
    }
    
   
	 
	 
	
	 
}
