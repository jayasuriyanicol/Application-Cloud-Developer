/*
 
 MAIN OF AZIENDA:
 
 	1.Create 3 Managers 
 		1.1. Work from 2025
 		1.2. Work from 2015
 		1.3. Work from 2005
 	
 	2. Azienda give work for 3 managers
 	
 	
 	3. Azienda do incrSalarioPerTutti() -> incrementation of salary for alla the people in ther 'Azienda'
 */


package eserciziLezione6;
import java.util.Date;

public class MainAzienda {

	    	public static void main(String[] args) {
	    		
	    		// 1. Create 3 Managers with specified work years: 2025 - 2015 - 2005
	   
	    		
	    		Manager m1 = new Manager("Cristiano Coccia", 1033.85, new Date(2025 - 1900, 10, 13), "Gippitina");
	    		
	    		Manager m2 = new Manager("Francesco Fidelini", 1500.85, new Date(2015 - 1900, 2, 11), "Giacomo");
	    		
	    	
	    	    Manager m3 = new Manager("Carla Benedettini", 2300.85, new Date(2005 - 1900, 4, 27), "Aldo");
	    	    
	    		
	    		Azienda azienda = new Azienda("Reenbac");
	    		
	    	    // 2. Azienda gives work for 3 managers (assume/hire them)
	    		
	    	    azienda.assume(m1);
	    	    azienda.assume(m2);
	    	    azienda.assume(m3);
	    	    
	    	    System.out.println("Dati Azienda PRIMA dell'incremento: ");
	    	    System.out.println(azienda.toString());
	    	    
	    	    
	    	    // 3. Azienda do incrSalario() -> incrementation of salary for all people in the 'Azienda'
	    	    double baseAumento = 5.00;
	    	    azienda.incrementoSalario(baseAumento);
	    	    
	    	    System.out.println(" Dati Azienda DOPO l'incremento di " + baseAumento);
	    	    System.out.println(azienda.toString());

	    	}

	    
	}





