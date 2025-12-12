package eserciziLezione9;

import java.util.ArrayList; 
public class Biglietteria {
	
	private double cassa;
	ArrayList<Tariffabile> coda = new ArrayList<>();

	
	public void aggiungiInCoda (Tariffabile t) {
		
		coda.add(t);
			
	}
	
	public Tariffabile riceviPagamento() {
		
		if (coda.size() == 0) {
			
			throw new ArrayIndexOutOfBoundsException("ATTENZIONE ! La cossa risulta vuota, deve essre presente almeno un elemento nella coda");
		}
		
		else {
			
			Tariffabile elemento = coda.get(0); 
			double prezzo = elemento.calcolaTariffa();
			cassa += prezzo;
			System.out.println("INCASSATO: " + prezzo + " EURO");
			coda.remove(0);
			
			return elemento;
			
		}
		
		
		
		
	}
		
		
		  public double getTotaleCassa() {
		        return cassa;
		    }
		
		
	
	

}



