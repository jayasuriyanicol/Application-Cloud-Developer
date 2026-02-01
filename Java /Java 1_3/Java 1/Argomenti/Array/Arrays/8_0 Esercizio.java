/*Exercise #8 – Different Elements
Take two arrays A and B, of length n and m, as input. Print all the elements
present in B, but not in A.
*/
package eserciziLezione3;

import java.util.Arrays;
import java.util.Scanner;

public class Esercizio8_0 {

	public static void main (String[] args) {
	
	int nn=0;
	int nm=0;
	
	Scanner scanner = new Scanner(System.in);
	
    //In this case, because is not specified by the exercise we assume that both A and B arrays can have different lenght
	do {
		
		System.out.println("Inserisci la lunghezza dell'ArrayA: ");
		nn = scanner.nextInt();
		
	    System.out.println("Inserisci la lunghezza dell'ArrayB: ");
	    nm = scanner.nextInt();
	    
	    
	    if (nn < 0 || nm < 0 || nn > 256 || nm > 256) {
	    	
	    	System.out.println("ATTENZIONE ! inserire un numero compresoi fra 1 e 255 nei due array A e B !");
	    }
	    
	    }while(nn < 0 || nm < 0 || nn > 256 || nm > 256);
	
	
	
	  int [] arrayA = new int[nn];
	  for (int i = 0; i < arrayA.length; i++) {
		  
		  System.out.println("Inserisci il " + i + "numero per l'arrayA: ");
		  arrayA[i] = scanner.nextInt();
		
	}
	  int [] arrayB = new int[nm];
	  for (int i = 0; i < arrayB.length; i++) {
		  
		  System.out.println("Inserisci il " + i + "numero per l'arrayB: ");
		  arrayB[i] = scanner.nextInt();
	
		  
	  }
	  
	  scanner.close();
	  
	  
	  //In this case I inverted the order of indicators form i -> j to j -> i to work properly
	  int [] arrayDiff = new int[nm];
	  int contatore = 0;
	  
	  for (int j=0; j< arrayA.length; j++) {
		  
		  boolean variabileA = false;
		  
		  for (int i=0; i<arrayB.length; i++) {
			  
			  
			  if(arrayB[j] == arrayA[i]) {
				  
				  variabileA = true;
				  break;
			}
		  }
			 if(!variabileA) {
				 
				  arrayDiff[contatore] += arrayB[j];
				  contatore ++;

			 }
				  
				  
			  
		  }
	  
	  //For avoid the print of null numbers, we implemented (with the help of AI) the Array.copyOf in order to have only the comun numbers
	  arrayDiff = Arrays.copyOf(arrayDiff,contatore);
	  
	  
	  //In this case I would like to re-write the comune array to preserve the utility of it
	  System.out.print("Valori in comune tra A e B sono : ");
	  
	  for (int i = 0; i < arrayDiff.length; i++) {
	      System.out.print(arrayDiff[i]);
	      if (i < arrayDiff.length - 1) {
	          System.out.print(", "); 
	          }
	  }
	
	
	
}
}



