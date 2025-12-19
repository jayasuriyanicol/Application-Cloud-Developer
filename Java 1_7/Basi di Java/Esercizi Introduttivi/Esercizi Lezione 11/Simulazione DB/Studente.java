package eserciziLezione11;
import java.io.Serializable;
import java.time.LocalDate;


public class Studente implements Serializable{
	
	
	private int Matricola;
	private String nome;
	private String corsoLaurea;
	
	private LocalDate dataImmatricolazione = LocalDate.now();
	
	
	public Studente (int Matricola, String nome, String corsoLaurea, LocalDate dataImmatricolazione){
		
		this.Matricola = Matricola;
		this.nome = nome;
		this.corsoLaurea = corsoLaurea;
		this.dataImmatricolazione = dataImmatricolazione;
		
	}
	
	
	
	
	
	public void setMatricola(int matricola) {
		Matricola = matricola;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public void setCorsoLaurea(String corsoLaurea) {
		
		this.corsoLaurea = corsoLaurea;
	}
	
	
	
	
	
	public int getMatricola() {
		
		return Matricola;
	}
	
	
	public String getNome () {
		
		return nome;
		
	}
	

	
	public String getCorsoLaurea() {
		
		return corsoLaurea;
	}
	
	
	public LocalDate getDataImmatricolazione() {
		
		return dataImmatricolazione;
		
	
	}





	@Override
	public String toString() {
		return "\n\nSTUDENTE \nMATRICOLA : " + Matricola + "\nNOME : " + nome + "\nCORSO DI LAUREA : " + corsoLaurea
				+ "\nDATA IMMATRICOLAZIONE: " + dataImmatricolazione ;
	}




	
	

	

	
	
	

}
