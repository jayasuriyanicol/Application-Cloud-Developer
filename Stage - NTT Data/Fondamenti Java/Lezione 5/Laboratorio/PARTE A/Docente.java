package Lezione_05;

public class Docente extends Persona {
	
	public String materia;
	
	public Docente(String nome, String cognome, String materia) {
		
		super(nome,cognome);
		this.materia = materia;
		
	}
	
	
	@Override
	public String presentati() {
		
		return "\nPiacere il mio nome è:\n " + getNomeCompleto() + "\nMATERIA INSEGNAMENTO :" + materia;
	}

	
	// ! GETTER & SETTER not mandatory
	public String getMateria() {
		return materia;
	}


	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	
	
	
	
	

}
