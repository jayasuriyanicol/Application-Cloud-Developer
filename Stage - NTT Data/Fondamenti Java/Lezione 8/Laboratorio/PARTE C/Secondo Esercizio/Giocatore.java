package Lezione_07;

public class Giocatore {
	
	private String nome,cognome,ruolo, età, cf;

	public Giocatore(String nome, String cognome, String ruolo, String età, String cf) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.ruolo = ruolo;
		this.età = età;
		this.cf = cf;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getEtà() {
		return età;
	}

	public void setEtà(String età) {
		this.età = età;
	}

	@Override
	public String toString() {
		return "GIOCATORE ->\nNOME: " + nome + "\nCOGNOME: " + cognome + "\nRUOLO: " + ruolo + "\nRUOLO" + età ;
	}
	
	
	
	
	
	
	
	

}
