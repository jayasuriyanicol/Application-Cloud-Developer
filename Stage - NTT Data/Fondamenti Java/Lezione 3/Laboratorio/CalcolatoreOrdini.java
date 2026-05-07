package Lezione_03;

public class CalcolatoriOrdini {
	
	public static void main(String[] args) {
		
		// Variabili della classe 
		Double prezzo = 50.0;
		Integer quantita = 3;
		Double percentualeSconto = 0.10;
		Double aliquotaIva = 0.22;
		
		
		//Richiamo dei metodi nel main
		double subtotale = calcolaSubtotale(prezzo,quantita);
		double sconto = calcolaSconto(subtotale,percentualeSconto);
		double imponibile= subtotale - sconto;
		double iva= calcolaIva(imponibile,aliquotaIva);
		double totale = calcolaTotale(imponibile,iva);
		
		calcolaSubtotale(prezzo,quantita);
		calcolaSconto(subtotale,percentualeSconto);
		calcolaIva(imponibile,aliquotaIva);
		calcolaTotale(imponibile,iva);
		stampaRicevuta(subtotale,sconto,iva,totale);
		
	}
	
	public static double calcolaSubtotale(double prezzo, int quantita) {
		
		return prezzo * quantita;
	}
	
	public static double calcolaSconto(double subtotale, double percentuale) {
		
		return subtotale*percentuale;
	}
	
	public static double calcolaIva(double imponibile, double aliquota) {
		
		return imponibile + aliquota;
	}
	
	public static double calcolaTotale(double imponibile, double iva) {
		
		return imponibile * iva;
		
	}
	
	public static void stampaRicevuta(
			double subtotale, double sconto,
			double iva,double totale) {
		
		System.out.println("SUBTOTALE: " +subtotale);
	    System.out.println("SCONTO: " +sconto);
	    System.out.println("IVA: " +iva);
	    System.out.println("TOTALE: " + totale);
	}
			
	
}
