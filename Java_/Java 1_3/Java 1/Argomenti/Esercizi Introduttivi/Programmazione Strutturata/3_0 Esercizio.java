/*Exercise number 3
 Red a integer number 'n>0' from the keyboard, print out the factorial of n number 
 Definition of factorial for n > 1:
 n! = n * ( n -1 ) * ( n -2 )... * 1.
 Per n= 1, n! = 1*/


package corsoBase;
import java.util.Scanner;
public class Esercizio3_0 {

	public static void main(String[] args) {
		
		int n = 0;
		int fattoriale = 1;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci il numero (n):" );
		n = scanner.nextInt();
		
		scanner.close();
		
		for (int i=1;i<=n;i++) {
			
			fattoriale = fattoriale * i;
		}
		System.out.println("Il fattoriale di "+ n +" è: "+ fattoriale);
		
	}

}
