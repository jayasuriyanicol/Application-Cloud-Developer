/*Exercise #5 (2P of a Triangle)
Let's consider two points in the Cartesian plane, A (x1, y1) and B (x2, y2).
Consider the right-angled triangle obtained by adding the point C(x2, y1).
Write a program that reads the values ​​x1, y1 and x2, y2 as input, calculates, and prints the 2p of the resulting triangle according to the above rules.

Example: if x1 = 1, y1 = 1, and x2 = 2, y2 = 2, then the 2P will be 3.414213562373095
Note: Use the Math library functions to calculate powers, square roots, etc. */

package corsoBase;

import java.util.Scanner;

public class Esercizio5_0 {

	public static void main(String[] args) {
		
	    int x1 = 0;
	    int x2 = 0;
	    int y1 = 0;
	    int y2 = 0;
	    int x3 = x2;
	    int y3 = y1;
	    
	    double Perimetro;
	    double Altezza;
	    double Lunghezza;
	    double Ipotenusa;
	    
	    
	    
	    Scanner scanner  = new Scanner(System.in);
	    
	    System.out.println("Inserisci la x1 del punto A: ");
	    x1 = scanner.nextInt();
	    
	    
	    System.out.println("Inserisci la y1 del punto A: ");
	    y1 = scanner.nextInt();
	    
	    
	    System.out.println("Inserisci la x2 del punto B: ");
	    x2 = scanner.nextInt();
	    
	    
	    System.out.println("Inserisci la y2 del punto B: ");
	    y2 = scanner.nextInt();
	    
	    scanner.close();
	    
	    
	    
	    Lunghezza = Math.abs(x2-x1);
	    Altezza = Math.abs(y2-y1);
	    
	    Ipotenusa = Math.sqrt(Math.pow(Lunghezza,2) + Math.pow(Altezza, 2));
	    
	    
	    
	    Perimetro = Lunghezza + Altezza + Ipotenusa;
	    
	    
	    
	    System.out.println("Il perimetro del triangolo rettangolo è di : " + Perimetro);
	    
	    
	    
	    
		
	}

}
