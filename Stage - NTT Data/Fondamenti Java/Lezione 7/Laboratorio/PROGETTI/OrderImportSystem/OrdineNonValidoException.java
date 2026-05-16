package Lezione_07;

@SuppressWarnings("serial")
public class OrdineNonValidoException extends Exception {
	
	
	public String messaggio;
	
	public OrdineNonValidoException(String messaggio) {
		
		this.messaggio = messaggio;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
	
	

}
