package Lezione_07;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Classifica {
	
	
	
	Map<String,Integer> classificaGiocatori = new HashMap<>();
	List<Giocatore> listaGiocatori = new ArrayList<>();
	
	
	@SuppressWarnings("unlikely-arg-type")
	public void aggiuntaGiocatore(Giocatore g) {
		
		if(listaGiocatori.contains(g.getCf())){
			
			System.out.println("ATTENZIONE ! Il CF inserito è già presente nel sistema");
			
			return;
		} 
		
		listaGiocatori.add(g);
		classificaGiocatori.put(g.getCf(), 0);
		System.out.println("SUCCESSO ! Il giocatore è stato aggiunto nel sistema");
	}
	
	
	public void aggiornamentoPunteggio(String g,Integer p) {
		
		if(classificaGiocatori.containsKey(g)){
			
			Integer punteggioAttuale = classificaGiocatori.get(g);
			classificaGiocatori.put(g,p+punteggioAttuale);
			System.out.println("SUCCESSO ! Il punteggio è stato aggiornato con successo !");
		}
		
		System.out.println("ATTENZIONE, non è presente un giocatore su quanto specificato");
		
	}
	
	
	public void stampaClassifica() {
		
		
		if(classificaGiocatori.isEmpty()) {
			
			System.out.println("ATTENZIONE ! la classifica risulta non essere presente");
		}
		
		
		for(Map.Entry<String,Integer> entry : classificaGiocatori.entrySet()) {
		
		System.out.println("\nSUCCESSO! Di seguito la classifica aggiornata !");
		System.out.println("\nCF: " + entry.getKey() + "PUNTEGGIO: " + entry.getValue() );
		
		}
	}
	
	
	public Boolean controlloEsistenzaGiocatore(String cf) {
		
		
		
		for(Giocatore g: listaGiocatori) {
		
			// ? In questo caso andiamo a utilizzare il equalsIgnoreCase, per il fatto che esso va a eliminare eventuali UPPER o Lower case
			if(g.getCf().equalsIgnoreCase(cf)) {
				
				System.out.println("SUCCESSO ! Risulta correttamente l'esistenza di un giocatore nel sistema ");
				return true;
			}
		
		
			System.out.println("ATTENZIONE ! Errore NON risulta l'esistenza di un giocatore nel sistema ");
			
			
			
		}
		return false;
	
	
	
	
}
}