package Lezione_05;

public class PagamentoCarta extends MetodoPagamento implements Notificabile {
	

// ! In questo caso andiamo con la creazione di una classe concreata che andrà a estendere una classe ABSTRACT e implementare un'interfaccia Notificabile

	
	
// ? Dobbiamo quindi una volta richiamati nell'extends e impl, i suddetti metodi, nel caso non li inseriamo genererà in automatico ERRORE.
	
	@Override
	public void paga(double importo) {
		
	  try {
			if(importo < 0) {
				
				throw new Exception("\nATTENZIONE ! L'importo deve essere maggiore o uguale a zero");
				
			}
			
			System.out.println("\nPAGAMENTO ELETTRONICO: " + importo + " EUR");
				
		}catch(Exception e) {
			
			throw new IllegalArgumentException("\nATTENZIONE ! L'importo deve essere maggiore o uguale a zero" + e.getMessage());
		}
	}
	

	@Override
	public void inviaNotifica(String messaggio) {
		
		try {
			
			if(messaggio == null ||  messaggio.trim().isEmpty()) {
				
				throw new Exception("\nATTENZIONE ! Il messaggio NON deve essere vuoto o solamente avere spazi\n");
				
			}
			
			System.out.println("\nNOTIFICA: "  + messaggio);
			
			
		}catch(Exception e) {
				
			throw new RuntimeException("\nATTENZIONE ! Il messaggio NON deve essere vuoto o solamente avere spazi\nERRORE:" + e.getMessage());
				
			}
	}
		
	}

	
