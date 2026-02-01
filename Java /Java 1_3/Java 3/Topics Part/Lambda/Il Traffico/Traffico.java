'''
Description 2 – Advanced Version

Write a Traffic class to manage cars.
Cars are defined by make, model, license plate, and Euro5 (boolean).
The list of cars is dynamically generated and will have a random size and composition.

A value for air conditions is then randomly generated (CO2 value, between 360 and 1000 ppm).
The class will store the last traffic ordinance related to license plates
(even or odd); the first ordinance will be decided randomly.



'''



package eserciziLezione12;
import eserciziLezione12.Automobile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("unused")
public class Traffico extends Automobile {
	
	private List<Automobile> automobili = new ArrayList<>();
	
	private static final Random r = new Random();
	
	
	private final Boolean euro5;
	private int C02;
	private String primaOrdinanza;
	private String ordinanzaAttuale;

	public Traffico(String marca, String modello, int targa, Boolean euro5) {
		super(marca, modello, targa, euro5);
		this.euro5 = euro5;
		
		this.C02 = r.nextInt(360,1001);
		
		if(r.nextInt(0,2) == 0) {
			
			this.primaOrdinanza = "dispari";

	} else {
		
		this.primaOrdinanza="pari";
	}
	
	}
	
	
	
	public static Traffico randomVehicle() {
		
		String [] randomMarche =  {"Renault", "Cupra", "Nissan", "Ford", "Toyota", "Setra"};
		String [] randomModello = {"Hybrid", "Cross", "Berlina", "RS", "Exclusive", "GTR" };
		
		int randomTarga = r.nextInt(0,9999);
		Boolean randomEuro5 = r.nextBoolean();
		
		String marca = randomMarche[r.nextInt(randomMarche.length)];
		String modello = randomModello[r.nextInt(randomModello.length)];
		
		return new Traffico(marca,modello,randomTarga, randomEuro5);
		
		
		
	}
	
	
	public String getOrdinanzaAttuale() {
		
		if (randomVehicle().getTarga() % 2 == 0) {
			 return "PARI";
		}
		else {
			
			 return "DISPARI";
		}
		
	}
	
	
	
	public String getPrimaOrdinanza() {
		
		return primaOrdinanza;
		
	}
	
	public int getC02() {
		
		return C02;
		
	}

	
    public Boolean geteuro5() {
    	
    	return euro5;
    }



	public Traffico getRandomVehicle() {
		
		return randomVehicle();
	}


 
  
    
}
