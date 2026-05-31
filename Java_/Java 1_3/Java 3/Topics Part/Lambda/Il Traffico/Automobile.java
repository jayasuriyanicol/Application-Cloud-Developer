'''
Description 1 – Basic Version
You want to create a method that applies filters to a list of cars to
determine which ones are authorized to circulate.
Implement the Automobile class with make, model, and license plate.
Implement the filter as a static method that

will receive as input the list of cars and an object of type Predicate<Automobile>
will return the new list of cars (which will be those authorized to circulate).

'''



package eserciziLezione12; 
import java.util.*;
import java.util.function.Predicate;


public class Automobile {
	
	private final String marca;
	private final String modello;
	private final int targa;
	private Boolean euro5;
	
	public Automobile(String marca, String modello, int targa, Boolean euro5) {
		
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		this.euro5 = euro5;
	
		
	}

	public void setEuro5(Boolean euro5){
		
		this.euro5 = euro5;
		
	}

	public String getMarca() {
		return marca;
	}

	public String getModello() {
		return modello;
	}

	public int getTarga() {
		return targa;
	}
	
	public Boolean getEuro5() {
		
		return euro5;
	}
	

	
	@Override
	public String toString() {
		return "\nDATI AUTOMOBILE | " + targa + " |: \n\nMARCA -> " + marca + "\nMODELLO -> " + modello + "\nTARGA -> " + targa + "]";
	}
	
	
	public static List<Automobile> filtroAutomobile (List<Automobile> showroom,Predicate<Automobile> a) {
		
		List<Automobile>listaAutomobili = new ArrayList<Automobile>();
		
		
		for(Automobile aut : showroom) {
			if(a.test(aut)) {
				
				listaAutomobili.add(aut);
			}

	}
		return listaAutomobili;
		
	}

	
}



