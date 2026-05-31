package eserciziLezione7;

public class Penne extends Articolo {
	
	private String colore;

	public Penne(String marca, String modello, double costo, String colore) {
		super(marca, modello, costo);
		this.colore = colore;
	}
	
	

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	@Override
	public String toString() {
		return "Penne [colore=" + colore + "]";
	}
	
	
	
	
	
	
	
	
	
	
	


}
