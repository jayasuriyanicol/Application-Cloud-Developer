package eserciziLezione7;


/*  
    * Gomme - Old Class
    ? Adding previous class of Gomme to test it with JUnit & Mock:
    ! Gomme(String marca, String modello, double costo, String forma, double dimensione): Constructor that initializes the object by calling the parent constructor (super) for the base attributes, and assigns the specific shape (forma) and size (dimensione).
    
    ! getDimensione(): Returns the current size (dimensione) of the eraser.

    ! setDimensione(double dimensione): Updates the size of the eraser.

    ! getForma(): Returns the current shape (forma) of the eraser.

    ! setForma(String forma): Updates the shape of the eraser.

    ! toString(): Overrides the default string representation to return a formatted string detailing the size (dimensione) and shape (forma) of the eraser.

*/

public class Gomme extends Articolo{
	
	
	private String forma;
	private double dimensione;
	
	
	public Gomme(String marca, String modello, double costo, String forma, double dimensione) {
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
