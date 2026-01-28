package Cartoleria2;

/*  
    * Azienda - Old Class
    ? Adding previous class of Azienda to test it with JUnit & Mock:

    ! Azienda(String anagrafica, double saldoCc): Constructor that initializes the object by calling super to set the registry details (anagrafica) and assigns the initial bank account balance (saldoCc).
    ! paga(double importo): Overrides the payment method to calculate a 10% commission and deducts the total sum (the original amount plus the commission) from the saldoCc.
    ! getSaldoCc(): Returns the current bank account balance (saldoCc).
    ! setSaldoCc(double saldoCc): Updates the bank account balance with the specified value.
    ! toString(): Overrides the default string representation to return a formatted string including "Azienda", the parent class details via super.toString(), and the current balance.
    
*/

public class Azienda extends Cliente {

	private double saldoCc;
	
	public Azienda(String anagrafica, double saldoCc) {
		super(anagrafica);
		this.setSaldoCc(saldoCc);
	}

	@Override
	public void paga(double importo) {
		// devo aggiungere all'importo il 10% di commissione
		double commiss = importo/10;
		saldoCc = saldoCc - (importo + commiss);

	}

	public double getSaldoCc() {
		return saldoCc;
	}

	public void setSaldoCc(double saldoCc) {
		this.saldoCc = saldoCc;
	}

	@Override
	public String toString() {
		return "Azienda: " + super.toString() + ", saldoCc=" + saldoCc;
	}

	
}
