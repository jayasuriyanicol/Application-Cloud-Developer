package Cartoleria2;


/*  
    * Articolo - Old Class
    ? Adding previous class of Articolo to test it with JUnit & Mock:


    ! Articolo(String marca, String modello, double costo): Constructor that initializes the object with the specified brand (marca), model (modello), and cost (costo).

    ! getMarca(): Returns the current brand name (marca) of the item.

    ! setMarca(String marca): Updates the brand name of the item.

    ! getModello(): Returns the current model name (modello) of the item.

    ! setModello(String modello): Updates the model name of the item.

    ! getCosto(): Returns the current cost (costo) of the item.

    ! setCosto(double costo): Updates the cost of the item.

    ! prezzoVendita(): Calculates and returns the selling price by doubling the base cost (costo * 2).

    ! toString(): Overrides the default string representation to return a formatted string containing the marca, modello, and costo followed by the Euro symbol.

    */

public class Articolo {
	
	
	private String marca;
	private String modello;
	private double costo;
	
	
	
	  Articolo(String marca, String modello, double costo) {
		  
		this.marca = marca;
		this.modello = modello;
		this.costo = costo;
	}



	  public String getMarca() {
		  return marca;
	  }



	  public void setMarca(String marca) {
		  this.marca = marca;
	  }



	  public String getModello() {
		  return modello;
	  }



	  public void setModello(String modello) {
		  this.modello = modello;
	  }



	  public double getCosto() {
		  return costo;
	  }



	  public void setCosto(double costo) {
		  this.costo = costo;
	  }
	
	  
	  
	  public double prezzoVendita() {
		  
		  return costo *2;
		  
		  
	  }
	  
	  @Override
		public String toString() {


			return marca + " " + modello + " " + costo + "€";


		}
	  
	  
	  
	  
	
	

}
