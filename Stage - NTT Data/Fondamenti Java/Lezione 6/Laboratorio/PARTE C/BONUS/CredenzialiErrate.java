package Lezione_06;

public final class CredenzialiErrate extends Accesso {

	
private final String messaggio;
	
	public CredenzialiErrate(String messaggio) {
		
		this.messaggio = messaggio;
		
	}
	
	public String getMessaggio() {
		
		return messaggio;
	}
}
