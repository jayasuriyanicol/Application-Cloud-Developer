package Lezione_05;

public class Persona {
	
	public String nome,cognome;
	
	public Persona(String nome, String cognome) {
		
		this.nome = nome;
		this.cognome= cognome;
		
		
	}
	
	public String getNomeCompleto() {
		
		String nomeCompleto = "\nNOME: "+  nome + "\nCOGNOME: " + cognome;
		
		
		return nomeCompleto;
	
	}
	
	
	public String presentati() {
	
	return "\nPiacere il mio nome è:\n " + getNomeCompleto();
    
	}
	
	
	// ! GETTER & SETTER not mandatory
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

	
	
}
