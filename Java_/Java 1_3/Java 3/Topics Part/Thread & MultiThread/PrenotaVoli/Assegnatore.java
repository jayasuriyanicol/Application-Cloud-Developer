package eserciziLezione13;


public class Assegnatore {
	
	private int numPostiVolo;
	private boolean postiDisponibili;
	
	
	public Assegnatore() {
		
		
		numPostiVolo = 20;
		postiDisponibili = true;
		
	
	}
	
	
	public synchronized int getTotalePosti() {
			
		return numPostiVolo;
	}
			

	
	public synchronized void assegnaPosti(String cliente, int numPosti) throws PostiNonDispException {
		
		if(!postiDisponibili) {
			
			throw new PostiNonDispException("ATTENZIONE ! Sistema BLOCCATO. Il volo risulta essere COMPLETO oppure NON OPERABILE");
		}
	
		if (numPosti <= numPostiVolo) {
					
			numPostiVolo -= numPosti;
			System.out.println("SUCCESSO ! Sono stati assegnati " + numPosti + " Posti !");
		}
		
		else {
			
			 System.out.println("ATTENZIONE ! Posti non disponibili, al di sopra di quelli richiesti\nPOSTI DISPONIBILI -> " + numPostiVolo + " POSTI");
			
			 throw new PostiNonDispException("ATTENZIONE ! Posti NON PRENOTABILI !");
				
		}
			
			
	}
	
	

	
}
