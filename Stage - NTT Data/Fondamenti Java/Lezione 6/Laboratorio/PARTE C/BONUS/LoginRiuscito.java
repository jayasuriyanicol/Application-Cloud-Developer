package Lezione_06;

public final class LoginRiuscito extends Accesso {
	
	private final String messaggio;
	
	public LoginRiuscito(String messaggio) {
		
		this.messaggio = messaggio;
		
	}
	
	public String getMessaggio() {
		
		return messaggio;
	}

}
