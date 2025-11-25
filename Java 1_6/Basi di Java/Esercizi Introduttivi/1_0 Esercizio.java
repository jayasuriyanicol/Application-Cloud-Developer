/*Exercise number 1
 Given two integer numbers n > 0 and k > 0 from keyboard, print the value of n elevate to k*/

package corsoBase;
import java.util.Scanner;
public class Esercizio1_0 {

	public static void main(String[] args) {
		
		
		int n = 0;
		int k = 0;
		double elevazione = 0;
	

		Scanner scanner  = new Scanner(System.in);
		
		System.out.println("Inserisci il primo numero (n): " );
		n = scanner.nextInt();
		
		System.out.println("Inserisci il secondo numero (k): ");
		k = scanner.nextInt();
		
		scanner.close();
		
	    elevazione = Math.pow(n,k);
	    
	    System.out.println("Elevazione: " + elevazione);
	}
	      
	    
}
	    
	    
		
		
		
		
		
	