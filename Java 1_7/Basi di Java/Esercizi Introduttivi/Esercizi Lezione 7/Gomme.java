package eserciziLezione7;

public class Gomme extends Articolo{
	
	
	private double dimensione;
	private String forma;
	
	public Gomme(String marca, String modello, String colore, double costo, double prezzoVendita, double dimensione, String forma) {
		super(marca,modello,costo);
		
		this.forma = forma;
		this.dimensione = dimensione;
	
	}

	public double getDimensione() {
		return dimensione;
	}

	public void setDimensione(double dimensione) {
		this.dimensione = dimensione;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	@Override
	public String toString() {
		return "Gomme [dimensione=" + dimensione + ", forma=" + forma + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
