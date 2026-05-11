package Lezione_05;

public class Studente extends Persona{
	
	
	public String matricola;
	
	public Studente(String nome,String cognome,String matricola) {
		
		super(nome,cognome);
		this.matricola = matricola;
	}
	
	@Override
	public String presentati() {
		
		return "\nPiacere il mio nome è:\n " + getNomeCompleto() + "\nMATRICOLA :" + matricola;

	
	}

	// ! GETTER & SETTER not mandatory
	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	
	

}
