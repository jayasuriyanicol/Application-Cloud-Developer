/* 
Exercise #3 - Copy Half an Array
Create an array A of n integers, dynamically populate only half of it, and
print it. Then populate the second half with the same values ​​as the first and print
again.
NB: For simplicity, let's assume the array size is an even number.
For example, I create a 10-element array and populate it with these 5 values ​​(3, 5, 8, 2, 4). In the end,
the array should become (3, 5, 8, 2, 4, 3, 5, 8, 2, 4).
*/


package eserciziLezione3;

import java.util.Scanner;

public class Esercizio3_0 {

	public static void main(String[] args) {
		
		int n = 0;
		
		Scanner scanner = new Scanner(System.in);
		do {
		   
			System.out.println("Benvenuto, inserisci la lunghezza voluta dell'ArrayA (SIA UN NUMERO PARI): ");
			n= scanner.nextInt();
			if (n%2!=0) {
				
				System.out.println("Perfavore, inserire un numero PARI");
			}
	}while(n%2!=0 || n > 256 || n <= 0);
		
		
	int pari = (n%2);
	int [] arrayA = new int [n];
	for (int i = 0; i < pari; i++) {
		
		System.out.println("Insersici LA PRIMA METÀ dei valori dell'ArrayA: ");
		arrayA[i] = scanner.nextInt();
		
	}
	
	for (int i=pari; i < n; i++) {
		
		System.out.println("Inserisci i valori della SECONDA METÀ dei valori dell'Array A: ");
		arrayA[i] = scanner.nextInt();
	}
		
	
	System.out.println("\nQuesti sono i valori dell'ArrayA: ");
	System.out.print("(");
	for (int i = 0; i < arrayA.length; i++) {
		
		if (i == arrayA.length - 1) {
		System.out.print(arrayA[i]);
		
	}else {
		
		System.out.print(arrayA[i] + ",");
	}

}
	System.out.print(")");
}
}