package Lezione_07;

@SuppressWarnings("serial")
public class ConfigurazioneNonValidaException extends Exception{
	
	public String messaggio;

	public ConfigurazioneNonValidaException(String messaggio) {
		
		this.messaggio = messaggio;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
	
	

}
