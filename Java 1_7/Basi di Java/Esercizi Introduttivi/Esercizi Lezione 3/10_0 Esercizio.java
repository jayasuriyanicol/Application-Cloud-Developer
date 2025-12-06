/*Exercise no. 10 - sorting
Given an array of integers as input, implement the Bubblesort algorithm to
sort it.
Finally print the sorted array.
Bubblesort is a famous sorting algorithm.
The purpose is the ascending order.
The data set is scanned, each pair of adjacent elements is
compared and the two elements are reversed in position if they are in the wrong
wrong. After the first scan, the LARGEST element is permanently positioned at the end of the array. Then we proceed with the scan of the sub
list obtained by ignoring the already placed item.
After performing a number of scans equal to (length - 1) of the array,
the list is definitely sorted.
Example: I have an array of 6 elements
Let's suppose we have 15 6 4 10 11 2
Initially 15 is compared with 6, and being 15> 6, the two numbers are
exchanged:
6 15 4 10 11 2
At this point the 15 is compared with the 4, and again exchanged:
6 4 15 10 11 2
At the end of the scan we will have
6 4 10 11 2 15
Now we will scan the sub-array obtained by ignoring the last element
6 4 10 11 2
The 6 will be exchanged with 4 but not with 10. So 10 does not swap with 11, but 11
is exchanged with 2. At the end of the second scan with the aforementioned exchanges, we will have
this situation
4 6 10 2 11 15
Proceeding in this way with each scan, at least one definitive element is positioned.
With a total of 5 scans, the array will be sorted.
*/
package eserciziLezione3;

import java.util.Scanner;

public class Esercizio10_0 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int n = 0;

		
		do {
			
			
			System.out.println("Inserisci la lunghezza dell'array: ");
			n = sc.nextInt();
			
			if (n < 0 || n > 256) {
				
				System.out.println("ATTENZIONE ! il numero deve essere maggiore di 1 e minore di 256 ");
				
				
			}
		}while(n<0 || n >256);
		
		
		
		int [] bubble = new int[n];
		
	   for (int i = 0; i < bubble.length; i++) {
		   
		   System.out.println("Inserisci il " + i + " elemento dell'Array Bubble ");
		   bubble[i] = sc.nextInt();
		
	   }
	   
	   
	   //I used the cycle of to for, to compare the previous with the next one, in order to re-order everything.
	   for (int i = 0; i < bubble.length; i++) {
		   if (i < bubble.length) {
			   
			   for (int j= i+ 1; j < bubble.length; j++)
				   
				   if (bubble[i] > bubble [j]) {
					   
					   
					   int vTemp = bubble[i];
					   
					   bubble[i] = bubble[j];
					   bubble[j] = vTemp;
				   }
		   }
		
	}
	   
	   
	  //Print the array bubble, in the  order correct form
	  System.out.print("Questa è l'Array bubble riordinato: [ ");
	  for (int i = 0; i < bubble.length; i++) {
		  if (i == bubble.length - 1) {
		System.out.print(bubble[i]);
	}else {
		
		System.out.print(bubble[i] + ",");
	}
	  }
	  System.out.print(" ]");
		
			
			
			
	
	}

}
