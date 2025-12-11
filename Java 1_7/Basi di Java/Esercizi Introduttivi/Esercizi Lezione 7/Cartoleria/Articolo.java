package eserciziLezione7;

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
