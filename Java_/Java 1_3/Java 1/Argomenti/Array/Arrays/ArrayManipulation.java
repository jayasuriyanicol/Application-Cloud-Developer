package corsoBase;

import java.util.Scanner;

public class Lezione3_0 {

	public static void main(String[] args) {
		
		Scanner scanner  = new Scanner(System.in);
		
		
		//Creation an array,creating the lenght of the array pre-defined
		int [] array = new int [5];
		System.out.println(array);
		
		
		
		//Iteration of every element of the array, until his lenght
		for (int i = 0; i < array.length; i++) {
			
			System.out.print(array[i] + "\t");
			
		}
		System.out.println();
		
		//Giving a value to position 3, position 2 -> -66
		array [2] = -66;
		
		
		//Printing the values -> array =  [0,0,-66,0,0]
		for (int i = 0; i < array.length; i++) {
			
			System.out.print(array[i] + "\t");
			
		}
		
		//Example with using char 
		char [] nome  =  {'c','a','n','e'};
		
		System.out.println();
		
		//Printing the lenght of char 
		System.out.println("La lunghezza della nostra CHAR è "  + nome.length);
		
		
		//Example of FOR EACH
	    for (char c : nome) {
	    	
	    	System.out.print(c + "\t");
			
		}
 }
	
}

