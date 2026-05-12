package Lezione_06;

public enum LivelloStudente {
	
	JUNIOR("Sei uno studente che è appena entrato, hai ancora tanto da imparare"),
	INTERMEDIO("Sei uno studente che ha delle buone conoscenze, consolidale"),
	AVANZATO("Sei uno studente che ha delle ottime conoscenze, il prossimo passo è l'assunzione !");
	
	private final String descrizione;
	
	private LivelloStudente(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String descrizione() {
		
		return descrizione;
	}


}
