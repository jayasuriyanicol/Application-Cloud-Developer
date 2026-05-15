package Lezione_07;

public class MainMagazzino {
	
		    public static void aggiungiProdotto (Prodotto prodotto, Magazzino magazzino) throws ProdottoNonValidoException {
		        
		        if (prodotto.getPrezzo() == null || prodotto.getPrezzo() < 0) {
		            throw new ProdottoNonValidoException("ATTENZIONE ! Impossibile inserire il prodotto '" + prodotto.getNome() + "'. Il prezzo non può essere negativo o nullo!");
		        }
		        
		        
		        if (prodotto.getNome() == null || prodotto.getNome().isBlank()) {
		            throw new ProdottoNonValidoException(" ATTENZIONE ! Impossibile inserire il prodotto. Il nome non può essere vuoto!");
		        }

		        
		        System.out.println("SUCCESSO ! Il prodotto '" + prodotto.getNome() + "' è stato registrato nel magazzino '" + magazzino.getNome() + "'.");
		    }

		    public static void main(String[] args) {
		        
		       
		        Magazzino mioMagazzino = new Magazzino("Via Santa Pazienza", "ITS ICT Academy");
		      
		        System.out.println("Nome: " + mioMagazzino.getNome());
		        System.out.println("Indirizzo: " + mioMagazzino.getIndirizzo());
		       

		        
		      
		        Prodotto griffin = new Prodotto("Cane", "il cane dei griffin", 67.67);
		        
		        try {
		        	
		            aggiungiProdotto(griffin, mioMagazzino);
		            
		        } catch (ProdottoNonValidoException e) {
		            System.out.println("ATTENZIONE ! Errore inatteso: " + e.getMessaggio());
		        }

		       // ? Prodotto NON valido a fini di TEST
		        Prodotto juan = new Prodotto("Juan Pablo", "ragazzo dalle mille sorprese", -104.67);
		        
		        try {
		            aggiungiProdotto(juan, mioMagazzino);
		            
		        } catch (ProdottoNonValidoException e) {
		         
		            System.out.println("ATTENZIONE BLOCCO CATTURATO!");
		            System.out.println("Messaggio di errore: " + e.getMessaggio());
		        }
		    }
		
}
