package lambda;


//Creation of Object Mela, using it for the Lambda Expression
public class Mela {
	
	private String colore;
	private int peso; //unit measure -> gr

	public Mela(String colore, int peso) {
		super();
		this.colore = colore;
		this.peso = peso;
	}

	public String getColore() {
		return colore;
	}
	public int getPeso() {
		return peso;
	}
	@Override
	public String toString() {
		return "\nMela \nCOLORE: " + colore + "\nPESO: " + peso ;
	}
	
	

}