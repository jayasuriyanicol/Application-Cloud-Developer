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
	

	
	
	
}
}
