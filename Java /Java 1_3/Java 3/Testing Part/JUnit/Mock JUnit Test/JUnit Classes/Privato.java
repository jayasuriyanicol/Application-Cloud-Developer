package Cartoleria2;

/*  
    * Privato - Old Class
    ? Adding previous class of Privato to test it with JUnit & Mock:

    ! Privato(String anagrafica, double cash): Constructor that initializes the object by calling super to set the registry details (anagrafica) and assigns the initial available cash (cash).

    ! paga(double importo): Overrides the payment method to directly deduct the specified amount (importo) from the current cash balance (cash).

    ! getCash(): Returns the current amount of cash available.

    ! setCash(double cash): Updates the amount of cash available.

    ! toString(): Overrides the default string representation to return a formatted string including "Privato", the parent class details via super.toString(), and the current cash balance.
*/


public class Privato extends Cliente {

	private double cash;
	
	public Privato(String anagrafica, double cash) {
		super(anagrafica);
		this.setCash(cash);
	}

	@Override
	public void paga(double importo) {
		cash = cash - importo;

	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		return "Privato: " + super.toString() + ", cash=" + cash;
	}

	
}
