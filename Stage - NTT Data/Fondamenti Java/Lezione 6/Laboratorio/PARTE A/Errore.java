package Lezione_06;

public final class Errore extends EsitoOperazione {
	
	private final String motivazioneErrore;
	
	public Errore(String motivazioneErrore) {
		
		this.motivazioneErrore = motivazioneErrore;
		
	}

	public String getMotivazioneErrore() {
		
		return motivazioneErrore;
	}
}
