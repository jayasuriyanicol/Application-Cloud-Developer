/* Exercise #5 – Zigzag Printing
Take an array A of n integers as input and print the elements in a zigzag pattern, that is, the
first and last, then the second and second-to-last, and so on.
NB: We assume an even size. */



package eserciziLezione3;
import java.util.Scanner;
public class Esercizio5_0 {
	

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
		
		
		int [] arrayA = new int[n];
		
		for (int i = 0; i < arrayA.length; i++) {
			
			System.out.println("Inserisci un valore per l'ArrayA: ");
			arrayA[i] = scanner.nextInt();
			
		}
		
		
		System.out.print("Array ZIG ZAG -> "+ "[");

		for (int i=0,  j = arrayA.length - 1;i <= j;i++, j--) {
			
			System.out.print(arrayA[i]);
			
			if (i != j) {
				
				System.out.print(arrayA[j]);
			}
		
			
			
		}
		System.out.print("]");
		
		
		

	}

}
