package Cartoleria2;


/*  
    * Penne - Old Class
    ? Adding previous class of Penne to test it with JUnit & Mock:
    ! Penne(String marca, String modello, double costo, String colore): Constructor that initializes the object by calling the parent constructor (super) for the base attributes and assigns the specific ink color (colore).

    ! getColore(): Returns the current ink color (colore) of the pen.

    ! setColore(String colore): Updates the ink color of the pen.

    ! toString(): Overrides the default string representation to return a formatted string detailing the color (colore) of the pen.

*/
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
