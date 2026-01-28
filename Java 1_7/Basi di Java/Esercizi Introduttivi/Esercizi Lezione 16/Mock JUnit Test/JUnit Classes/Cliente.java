package Cartoleria2;


/*  
    * Cliente - Old Class
    ? Adding previous class of Cliente to test it with JUnit & Mock:

    ! Cliente(String anagrafica): Constructor that initializes the client with the specified registry details (anagrafica).
    ! getAnagrafica(): Returns the current registry details (anagrafica).
    ! setAnagrafica(String anagrafica): Updates the registry details (anagrafica) for the client.
    ! toString(): Overrides the default string representation to return a string containing the anagrafica details.
    ! paga(double importo): An abstract method that enforces concrete subclasses to implement their own specific logic for processing a payment of the given amount (importo).
*/

public abstract class Cliente {

	private String anagrafica;

	public Cliente(String anagrafica) {
		this.anagrafica = anagrafica;
	}

	public String getAnagrafica() {
		return anagrafica;
	}

	public void setAnagrafica(String anagrafica) {
		this.anagrafica = anagrafica;
	}

	@Override
	public String toString() {
		return "anagrafica=" + anagrafica;
	}
	
	public abstract void paga(double importo);
	

	
	
}
