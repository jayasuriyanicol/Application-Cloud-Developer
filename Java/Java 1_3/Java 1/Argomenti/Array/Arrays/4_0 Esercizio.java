/*Exercise #4 – Sum of Array Elements
Create an array A of n internal numbers and populate it dynamically.
Calculate and print:
 the sum of all elements
 the sum of the elements in even places (zero is counted among even numbers!)
 the sum of the elements in odd places
 the arithmetic mean of all elements
*/
package eserciziLezione3;
import java.util.Scanner;
public class Esercizio4_0 {

	public static void main(String[] args) {
		
		int n = 0;
		
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("Benvenuto, inserisci la lunghezza dell'array: ");
			n = scanner.nextInt();
			
			if (n <0 || n > 256) {
				System.out.println("ATTENZIONE Ù1 il numero inserito è maggiore di 256 o minore di 0 !");
			}
			}while(n<0 || n > 256);
		
		  int [] arrayA = new int [n];
		  
		  int somma = 0;
		  int sommaPari = 0;
		  int sommaDispari = 0;
		  
		  for (int i = 0; i < arrayA.length; i++) {
			  System.out.println("Inserisci il numero dentro l'arrayA: ");
			  int valoreCorrente = scanner.nextInt();
			  arrayA[i] = valoreCorrente;
			  
			  somma += valoreCorrente;
			//Calculating the sum (odd position), element that satisfy the condition
			  if (i % 2 == 0) {

				  sommaPari  += valoreCorrente;	
			  } else {
				  
				  sommaDispari += valoreCorrente;
			  }
				  
			  }
		

		 double mediaAritmetica = (double) somma / arrayA.length;
		 
		System.out.println("Somma: " + somma);
		System.out.println("Somma Pari: " + sommaPari);
		System.out.println("Somma Dispari : " + sommaDispari);
		System.out.println("Media Artimetica: " + mediaAritmetica);
	}

	
}
