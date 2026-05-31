package corsoBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Lezione8_0 {

	public static void main (String [] args) {
		
	//Example of sorting the string from an ArrayList
	ArrayList<String> nomi = new ArrayList<>();
	
	nomi.add("Nicol");
	nomi.add("Cristiano");
	nomi.add("Giacomo");
	nomi.add("Francesco");
	
	
	//Collection -> Interface, Collections -> class with static methods.
	Collections.sort(nomi);
	

	
	//Print the names in alphabetical order
	for(String string : nomi) {
		
		System.out.println(string);
	}
	
	/*On the other hand, if we want to compare each string in a different modality, we can use the compareator
	
	Creating the class and add java.util.Comparator.
	
	Code: 
	
		public class StringComparator implements Comparator<String> {
		
		@Override
		public int compare(String o1, String o2) {
			
			
			//Using (-1) we invert the sign 
			return (-1) * 01.compareTo(02);
			
		   //In the main, we can add:
			
			Collections.sort((nomi, new StringComparator());
			
			//Print the names not in alphabeltical order
			for(String string : nomi) {
				
				System.out.println(string);
			}
			
		
			
		}
	}

    */
	
	
	
	/*
	 Other type of example, list of Impiegati
	 
	 ArrayList<Impiegato> listaImp = new ArrayList<>();
	 
	 listImp.add(new Impiegato("Mario", 1500, new Date());
	 listImp.add(new Impiegato("Anna",  1350, new Date(120,1,1));
	 listImp.add(new Impiegato("Mario", 1525, new Date(110,5,30));
	 listImp.add(new Impiegato("Manuel",1300, new Date(125,1,1));
	 
	 //Error : it can execute because is not comparable. So, going to class Impiegato and add comparable in the class and do the override.
	 //Collections.sort(listaImp);
	 
	 //After we manage the situation, we can continue and print it 
	 for (Impiegato impiegato : listaImp) {
	 
	 	System.out.println(impiegato);
	 
	 }
	 
	 /*CLASS IMPIEGATO:
	  
	   public class Impiegato implements Comparable
	   
		   @Override
		   public int compareTo(Impiegato o) {
		   	
		   	//Criterio, order by sort asc name
		   	return this.nome.compareTo(o.nome);
	
	   
	   	return 0;
	   	}
	   	
	  	//Finally, we have to rember if a specific method is used more than once a time, we need to create a specific class for the function and invocate it.
	  	//Basically, before start coding is a good behaviour to check if there are some method to create.
	  	
	  				//Syntax ->  Collections.sort(listArray, comparator)
	  	
	  	 */
	 
	 

	

	
	
	
}
}
