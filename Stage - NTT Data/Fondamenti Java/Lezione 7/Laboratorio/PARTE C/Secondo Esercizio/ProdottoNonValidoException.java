package Lezione_07;

@SuppressWarnings("serial")
public class ProdottoNonValidoException extends Exception {
		
	public String messaggio;
	
	
	public ProdottoNonValidoException(String messaggio) {
		
		this.messaggio = messaggio;
		
	}


	public String getMessaggio() {
		return messaggio;
	}


	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
	
	

	

}
