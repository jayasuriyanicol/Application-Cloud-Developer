/* 
 Exercise #6
Read an integer n > 0 from the keyboard and perform the prime factorization, printing all divisors.
Example: Enter 12, and the prime factorization would be 22 * ​​3, or 4 * 3.
The program should print 2 * 2 * 3.
If the number is prime, the program will print "The number is prime.
*/

package corsoBase;

import java.util.Scanner;

public class Esercizio6_0 {

	public static void main(String[] args) {


		
		Scanner scanner = new Scanner(System.in);
		int n;
		
		
		System.out.println("Inserisci un numero: ");
		
		do {
			n = scanner.nextInt();
			
			if (n <= 0) {
				
				System.out.println("Inserire un numero > 0");
			}
			
		} while (n <= 0);
		
		System.out.println("Hai inserito\t" + n + "\n");
		
		System.out.print("I fattori di " + n + ": ");
		
		boolean first = true;
		
		while (n > 1) {
			for (int c = 2; c <= n; c++) {
				if (n % c == 0) {
					if (first) {
						System.out.print(c);
						first=false;
					} else {
						System.out.print("*" + c);
					}
					n /= c;
					break;
				}
			}
		}
	}
}