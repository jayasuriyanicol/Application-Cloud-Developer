package eserciziLezione5;

public class MainTamagotchi {

	public static void main(String[] args) {
		
		Tamagotchi t1 = new Tamagotchi ("Gippitina", "Elefante");
		Tamagotchi t2 = new Tamagotchi ("Giacomo", "Canarino");
	
		System.out.println(t1);
		
		System.out.println(t1.mangia());
		System.out.println(t1.gioca());
		
		
		System.out.println(t2.gioca());
		System.out.println(t2.mangia());
		System.out.println(t2.gioca());
		
		System.out.println(t1.getSpecie());
		System.out.println(t2.getSpecie());
		
		

			
	
	}

}
