package Lezione_05;

public class PagamentoPayPal extends MetodoPagamento implements Notificabile {
	
	@Override
	public void paga(double importo) {
		
		try {
			
			if(importo < 0) {
				
				throw new Exception("\nATTENZIONE ! L'importo deve essere maggiore o uguale a zero");
				
			}
			
			System.out.println("\nPAGAMENTO PayPal: " + importo +  " EUR");
			
		}catch(Exception e) {
				
			throw new IllegalArgumentException("\nATTENZIONE ! L'importo deve essere maggiore o uguale a zero" + e.getMessage());
				
			}
	}
	
	@Override
	public void inviaNotifica(String messaggio) {
		
		try {
			
			if(messaggio == null || messaggio.trim().isEmpty()) {
				
				throw new Exception("\nATTENZIONE ! Il messaggio NON deve essere vuoto o solamente avere spazi\n");
				
			}
			
			System.out.println("\nNOTIFICA: "  + messaggio);
			
			
		}catch(Exception e) {
				
			throw new RuntimeException("\nATTENZIONE ! Il messaggio NON deve essere vuoto o solamente avere spazi\nERRORE:" + e.getMessage());
				
			}
	}
		
	}

