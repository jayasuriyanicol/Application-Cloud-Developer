/*
To test the Stack class that models a LIFO structure, we using the Tamagotchi exercise
 */


package eserciziLezione10;
import eserciziLezione5.Tamagotchi;

public class MainPila {
		
	
	public static void main(String[] args) {
		
		
		Pila <Tamagotchi> pilaLIFO = new Pila<>();
		
			Tamagotchi t1 = new Tamagotchi("Giacomo");
	
	
			Tamagotchi t2 = new Tamagotchi("Francesco", "Cris");


	

		pilaLIFO.addOb(t1);

		pilaLIFO.addOb(t2);




		System.out.println(pilaLIFO);





		pilaLIFO.removeOb();


		


		System.out.println("\nRIMOZIONE TAMAGOTCHI:");


		System.out.println(pilaLIFO);




		pilaLIFO.removeOb();


		pilaLIFO.removeOb();


	}



		
		
		
	}
	
	

