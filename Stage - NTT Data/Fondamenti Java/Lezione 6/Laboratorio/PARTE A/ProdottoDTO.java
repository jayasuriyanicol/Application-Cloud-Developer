package Lezione_06;

public record ProdottoDTO(String nome, Double prezzo) {
    	
	// ? Andiamo con la validazione dei vari parametri nel costruttore, per verificare che effettivamnete siano validi.
	public ProdottoDTO {
    	
		if (nome == null || nome.trim().isEmpty()) {
			
			throw new IllegalArgumentException("ATTENZIONE ! E richiesto che il campo abbia almeno un carattere");
		}
	    
		if(prezzo < 0) {
			
			throw new IllegalArgumentException("ATTENZIONE ! Il prezzo deve essere maggiore di 0");
		}
    	
    }
}
   
