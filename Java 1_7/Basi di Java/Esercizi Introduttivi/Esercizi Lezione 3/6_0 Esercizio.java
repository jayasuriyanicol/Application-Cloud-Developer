/* 
 * Exercise #6 - Array Inversion Ver. 2
Take an array A of n integers as input and reverse the order of its elements.
NB: Use ONLY the initial array.
Example: If A is (10, 27, 13, 4), then I need to get A (4, 13, 27, 10).
When the calculation is complete, print array A.
*/


package eserciziLezione3;

import java.util.Scanner;

public class Esercizio6_0 {

	public static void main(String[] args) {
		
		
		int n = 0;
		
		Scanner scanner  = new Scanner (System.in);
		
		do {
			System.out.println("Inserisci la lunghrezza desiderata per l'arrayA: ");
			n = scanner.nextInt();
			
			if(n<0 || n>256) {
				
				System.out.println("ATTENZIONE ! Il valore inserito deve essere maggiore di 0 e minore di 256");
			}
			
		}while(n<0 || n > 256);
		
		
		int [] arrayA = new int [n];
		
		for (int i = 0; i < arrayA.length; i++) {
			
			System.out.println("Inserisci un valore per l'arrayA: ");
			arrayA[i] = scanner.nextInt();
			
			
		}
		
		scanner.close();
		
		//To use a unique arrayA to invert everything, we have to use a variableTemp to cicle half array per time
		int variabileTemp;
		
		for(int i=0; i <n/ 2; i++) {
			
			//First half, saved into the arrayA (left side)
			variabileTemp = arrayA[i];
			//Re-Write the initial with the right side
			arrayA[i] =  arrayA[n-1-i];
			//Ultime the final value with the initial value
			arrayA[n-1-i] = variabileTemp;
					
		}
		
		
		  //Print out, all the array, with comma form
		   System.out.print("ArrayA in forma inversa: [");
		   for (int i = 0; i < arrayA.length; i++) {
			   
			   if(i == arrayA.length - 1) {
				  
			   System.out.print(arrayA[i]);
			   }else {
				   
				   System.out.print(arrayA[i] + ",");
			   }
			   
		   
			
		}
		   System.out.print("]");
		}
	}
	
	
	
