package eserciziLezione3;
import java.util.Scanner;
import java.util.Arrays;
public class Esercizio7_0 {
	
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
		  
		  
		  //We go to keep the max length from both arrays A and B, with Math.max and adding a counter 'contatore' , to implement the Arrays.copyOf
		  int lungh = Math.max(nn, nm);
		  int [] arrayComune = new int[lungh];
		  int contatore = 0;
		  
		  for (int i=0; i< arrayA.length; i++) {
			  
			  for (int j=0; j<arrayB.length; j++) {
				  
				  
				  if(arrayA[i] == arrayB[j]) {
					  
					  arrayComune[contatore] += arrayA[i];
					  contatore ++;
				  }
					  
					  
				  }
			  }
		  
		  //For avoid the print of null numbers, we implemented (with the help of AI) the Array.copyOf in order to have only the comun numbers
		  arrayComune = Arrays.copyOf(arrayComune,contatore);
		  
		  
		  //In this case I would like to re-write the comune array to preserve the utility of it
		  System.out.print("Valori in comune tra A e B sono : ");
		  
		  for (int i = 0; i < arrayComune.length; i++) {
		      System.out.print(arrayComune[i]);
		      if (i < arrayComune.length - 1) {
		          System.out.print(", "); 
		          }
		  }
		
		
		
	}
}


