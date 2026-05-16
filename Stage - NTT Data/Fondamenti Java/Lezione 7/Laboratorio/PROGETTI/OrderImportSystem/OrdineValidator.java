package Lezione_07;

public class OrdineValidator {

	public static void validazioneOrdine(Ordine ordine) throws OrdineNonValidoException {
		
		
	    if(ordine.cliente() == null || ordine.cliente().isBlank()) {
	    	
	    	
	    	throw new OrdineNonValidoException("ATTENZIONE ! il campo CLIENTE inserito non risuta valido, cliente nullo o mancante !");
	  
	    }
	    
	    Integer qnt = ordine.quantità();
	    
	    if(qnt == null || (qnt < 0)) {
	    	
	    	throw new OrdineNonValidoException("ATTENZIONE ! il campo QUANTITA' inserito non risuta valido, QUANTITA' nulla o inferiore a zero !");
	    }
	    
	    
	    Double prezzo = ordine.prezzoUnitario();
	    
	    if(prezzo == null || (prezzo < 0.0)) {
	    	
	    	throw new OrdineNonValidoException("ATTENZIONE ! il campo PREZZO inserito non risuta valido, PREZZO nullo o inferiore a 0.0 !");
	    	
	    }
	    
	    if(ordine.calcolaTotale() < 0.0) {
	    	
	    	throw new OrdineNonValidoException("ATTENZIONE ! Il TOTALE non può essre inferiore a ZERO !");
	    }
	    
	    
	   if(ordine.riepilogo().equals("")) {
		   
		   throw new OrdineNonValidoException("ATTENZIONE ! il RIEPILOGO risulta essere nullo !");
	   }
}
}