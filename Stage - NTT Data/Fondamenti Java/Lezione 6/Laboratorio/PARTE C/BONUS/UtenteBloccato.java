package Lezione_06;

public final class UtenteBloccato extends Accesso {
	
private final String messaggio;
	
	public UtenteBloccato(String messaggio) {
		
		this.messaggio = messaggio;
		
	}
	
	public String getMessaggio() {
		
		return messaggio;
	}

}
