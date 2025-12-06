package eserciziLezione5;

import java.util.Random;

public class Dado {
	
	public final static int ricarico = 5;
	
	
	private Dado() {
		
	}
	
	public static int estrai() {
		
		return new Random().nextInt(1,7);
		
	}

}
