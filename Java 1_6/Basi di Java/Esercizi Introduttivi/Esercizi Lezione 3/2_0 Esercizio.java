/* Exercise #2 - Array Inversion
Taking an array A of n integers as input, create a second array B of the same size and populate it by reversing the order of the elements of the first
Example: If A is (10,27,13, 4), then I need to get B (4,13,27,10).
After processing, print arrays A and B
*/

package eserciziLezione3;

import java.util.Scanner;

public class Esercizio2_0 {

	public static void main(String[] args) {
		
		
		int n = 0;
		
	
	   Scanner scanner  = new Scanner (System.in);
	   
	   do {
		   System.out.println("Benvenuto, inserire la lunghezza dell'Array A: ");
		   n = scanner.nextInt();
		   
		   if(n<0 || n > 256) {
			   
			   System.out.println("\nATTENZIONE, inserisci un numero maggiore di 1 e minore di 256.");
		   }
	   }while(n<0 || n >256);
	   
		
			   
		int [] arrayA = new int [n];
	    int [] arrayB = new int [n];
	    
	    for (int i = 0; i < arrayA.length; i++) {
		  
		   System.out.println("Inserisci il valore nell'array A: ");
		   arrayA[i] = scanner.nextInt();
		   
	}
	   
       for(int i = (n-1); i >=0 ; i--) {
    	   arrayB[n-1-i] = arrayA [i];
    	   
       }
			 
		 
	   
       System.out.println("\nQuesti sono i valori dell'Array A (FORMA NORMALE): ");
       System.out.print("[");
	   for (int i = 0; i < arrayA.length; i++) {
		   
		   if(i == arrayA.length - 1) {
			  
		   System.out.print(arrayA[i]);
		   }else {
			   
			   System.out.print(arrayA[i] + ",");
		   }
	   
		
	}
	   System.out.print("]");
	   
	   System.out.println("\nQuesti sono i valori dell'Array B (FORMA INVERSA): ");
	   System.out.print("[");
	   for (int i = 0; i < arrayB.length; i++) {
		   
		   if(i == arrayB.length - 1) {
			  
		   System.out.print(arrayB[i]);
		   }else {
			   
			   System.out.print(arrayB[i] + ",");
		   }
		   
	   
		
	}
	   System.out.print("]");
	   	}
	    
		
}