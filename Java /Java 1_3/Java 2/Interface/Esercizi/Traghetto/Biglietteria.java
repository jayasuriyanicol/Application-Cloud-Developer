package eserciziLezione9;

import java.util.ArrayList; 
public class Biglietteria  {
	
	private double cassa;
	ArrayList<Tariffabile> coda = new ArrayList<>();

	
	public void aggiungiInCoda (Tariffabile t) {
		
		coda.add(t);
			
	}
	
	public Tariffabile riceviPagamento() throws CodaVuota{
		
		
		//In this case, to use a personalize custom throwable, we add an 'CodaVuota' special constructed exceptio method.
		if (coda.size() == 0) {
			
			throw new CodaVuota("ATTENZIONE ! La coda risulta vuota, deve essere presente almeno un elemento nella coda !");
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



