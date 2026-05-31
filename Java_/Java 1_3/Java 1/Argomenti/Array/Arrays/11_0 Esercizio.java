/* Exercise no. 11 (Merge between two ordered arrays)
Read 2 arrays of integers from the keyboard, sort with the previous
method. Then create a third array that has the union of the elements and
keep the sort.
NB: if an element is present in both arrays, in the third array it must
appear only once

*/

package eserciziLezione3;

import java.util.Arrays;
import java.util.Scanner;

public class Esercizio11_0 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int nn = 0;
		int nm = 0;
		
		do {
			
			
			System.out.println("Inserisci la lunghezza del PRIMO array: ");
			nn = sc.nextInt();
			
			System.out.println("Inserisci la lunghezza del SECONDO array: ");
			nm = sc.nextInt();
			
			if (nn < 0 || nn > 256 || nm < 0 || nm > 256) {
				
				System.out.println("ATTENZIONE ! il numero deve essere maggiore di 1 e minore di 256 , in ENTRAMBI gli ARRAY");
				
				
			}
		}while(nn<0 || nn>256 || nm < 0 || nm > 256);
		
		
		//Creation of three arrays: b1,b2 for the arrays to order and the third one the merged 'bubbleMerge'
		
		int [] b1 = new int [nn];
		int [] b2 = new int [nm];
		
		int bb = Math.max(nn, nm);
		
		int [] bubbleMerge = new int[bb];
		
		
	   for (int i = 0; i < b1.length; i++) {
		   
		   System.out.println("Inserisci il " + i + " elemento dell'Array Bubble ");
		   b1[i] = sc.nextInt();
		
	   }
	   
	   for (int i = 0; i < b2.length; i++) {
		   
		   System.out.println("Inserisci il " + i + " elemento dell'Array Bubble ");
		   b2[i] = sc.nextInt();
		
	   }
	   
	   
	   //I used the cycle of to for, to compare the previous with the next one, in order to re-order everything. Same for the others one
	   for (int i = 0; i < b1.length; i++) {
		   if (i < b1.length) {
			   
			   for (int j= i+ 1; j < b1.length; j++)
				   
				   if (b1[i] > b1 [j]) {
					   
					   
					   int vTemp = b1[i];
					   
					   b1[i] = b1[j];
					   b1[j] = vTemp;
				   }
		   }
		
	}
	   
	   for (int i = 0; i < b2.length; i++) {
		   
		   
		   if (i < b2.length) {
			   
			   for (int j= i + 1; j < b2.length; j++) {
				   
				   if (b2[i] > b2[j]) {
					   
					   int vTemp2 = b2[i];
					   b2[i] = b2[j];
					   b2[j] = vTemp2;
				   }
			   }
		   }
		   
	   }
	   
	   
	   //We merge the two ORDERD b1,b2 
	   bubbleMerge = new int [nn+nm];
	   
	   
	   //Now, we cycle with 3 indicators, in order to compare and 'paste' it to the bubbleMerge array
	   int i =0;
	   int j = 0;
	   int k = 0;
	   
	   while(i< nn && j < nm) {
		   
		   if (b1[i] < b2 [j]) {
			   
			   bubbleMerge[k] = b1[i];
			   i++;
			   k++;
		   }
		   
		   else if (b2[j] < b1[i]) {
			   
			   bubbleMerge[k] = b2[j];
			   j++;
			   k++;
		   }
	       
		   else {
			   bubbleMerge[k] = b2[j];
			   i++;
			   j++;
			   k++;
		   }
	   }
	   
	   
	   //Last one, in order to prevent some none positions we want to be sure to 'consume' all the position in the arrays b1 and b2
	   while(i<nn) {
		   
		   bubbleMerge[k++] = b1[i++];
		   
	   }
	   while(j<nm) {
		   
		   bubbleMerge[k++] = b2[j++];
		   
	   }
	   
	   
	   
	   //Print the array bubbleMerge, in the  order correct form
	   
	   bubbleMerge = Arrays.copyOf(bubbleMerge, k);
	   
	  
	  System.out.print("Questa è l'Array bubble riordinato: [ ");
	  for (int f = 0; f < bubbleMerge.length; f++) {
		  if (f == bubbleMerge.length - 1) {
		System.out.print(bubbleMerge[f]);
	}else {
		
		System.out.print(bubbleMerge[f] + ",");
	}
	  }
	  System.out.print(" ]");
		
			
			
			
	
	}

}
