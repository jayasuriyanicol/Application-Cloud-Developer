package Lezione_02;

public class ScontoCliente {

	public static void main(String[] args) {
		
		Double prezzo = 12.00;
		Boolean clientePremium = false;
		Integer sconto = 0;
		Double prezzoScontato = 0.0;
		
		System.out.println("PREZZO INIZIALE" + prezzo);
		
		
		
		
		if (prezzo > 100 && clientePremium){
			
			 prezzoScontato = prezzo*20/100;
			sconto = 20;
		
		}
		if (prezzo > 100 &&  !clientePremium) {
			
			 prezzoScontato = prezzo*10/100;
			sconto = 10;
		}
		
		if (prezzo <= 100) {
			
			sconto = 0;
			System.out.println("ATTENZIONE! Nessuno sconto applicato");
			
		}
		
		
		if (sconto == 0) {
			
			System.out.println("Nessun sconto esistente!");
		}
		
	
	System.out.println("PERCENTUALE SCONTO ->" + sconto + " %");
	System.out.println("IMPORTO SCONTO -> " + sconto );
	System.out.println("PREZZO FINALE -> " + prezzoScontato);
	
	

	}

}
