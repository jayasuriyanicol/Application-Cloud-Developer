package eserciziLezione8;

public class Cane extends AnimaleTerrestre{
	
	
	public String verso() {
		
		return " Bau Bau";
	}
	
	public String toString() {
		
		return  categoria() + " sono, un CANE faccio: " + verso();
	}

}
