package eserciziLezione10;

public class Performer {
	
	
	private String nome;
	public int voti;

	
	
	
	public Performer(String nome ) {
		
		this.nome = nome;
		this.voti = 0;
		
	}
	
	

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public void incrementaVoti() {
		
			
			 this.voti++;

		
	}
	
	
	public int getVoti() {
		return voti;
	}


	public String getNome() {
		return nome;
	}

	



	@Override
	public String toString() {
		return "\nPERFORMER \n\nNOME PERFORMER -> " + nome + "\nVOTI -> " + voti;
	}
	
	

}
