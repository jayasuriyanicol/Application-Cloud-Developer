package eserciziLezione8;

public class Canarino extends AnimaleVolatile {
	
	
	
	public String verso() {
		
		return " Cip Cip";

	}
	
	
	@Override
	public String toString() {
		return categoria() + ", sono un CANARINO, faccio  " + verso();
	}

}
