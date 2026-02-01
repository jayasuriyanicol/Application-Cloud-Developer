/*Exercise #1 – Copy Array
Taking an array A of n integers as input, create a second array of the same size 
and populate it by copying all the elements of the first.
*/

package eserciziLezione3;
import java.util.Scanner;
public class Esercizio1_0 {

	public static void main(String[] args) {
		
		int n = 0;
	
	
		Scanner scanner = new Scanner (System.in);
		
		do {
        System.out.println("\nInserisci la lunghezza dell'array A: ");
        n = scanner.nextInt();
        
        	if(n<=0 || n> 256) {
        		System.out.println("\nATTENZIONE, inserisci un numero maggiore di 1 e minore di 256.");
        	}
		} while(n <= 0 || n > 256);
		
		
		int [] arrayA = new int [n];
		int [] arrayB = new int [n];
		
        for (int i = 0; i < arrayA.length; i++) {
				  
			   System.out.println("Inserisci il valore nell'array A: ");
			   arrayA[i] = scanner.nextInt();
				arrayB = arrayA;
		}

		System.out.println("\nQuesti sono i dati dell'array A: " );
		System.out.print("[");
		for (int i = 0; i < arrayA.length; i++) {
			
			if(i == arrayA.length - 1) {
				System.out.print(arrayA[i]);
			}else {
				
				System.out.print(arrayA[i] + ",");
			}
		
		}
		System.out.print("]");
		
		
		System.out.println("\nQuesti sono i dati dell'Array B: " );
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
