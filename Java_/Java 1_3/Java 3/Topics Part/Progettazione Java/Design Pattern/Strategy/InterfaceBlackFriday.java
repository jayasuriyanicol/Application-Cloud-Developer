package eserciziLezione13;

public class InterfaceBlackFriday implements Sconto {

	public double scontoApplicato(double prezzo) {
		
		return prezzo * 0.20;
	}
}
