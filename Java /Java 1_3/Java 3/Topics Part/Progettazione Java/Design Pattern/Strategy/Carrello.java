package eserciziLezione13;

import java.util.ArrayList;

public class Carrello {

	
	private ArrayList<Prodotto> ListaProdotti  = new ArrayList<>();
	
	private double prezzoTotale;
	
	
	public void aggiungiProdotto(Prodotto p) {
		
		ListaProdotti.add(p);
		
    }
	
	public double calcolaTotale( Sconto sconto) {
		
		prezzoTotale = 0;
		
		for(Prodotto pr: ListaProdotti) {
			
			prezzoTotale= pr.getPrezzoUnitario();
			
			prezzoTotale -= sconto.scontoApplicato(prezzoTotale);
		}
		return prezzoTotale;
	}
		
		
}