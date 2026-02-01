/*
1) Numeric string

The program reads a string from the keyboard and checks whether the entered text consists only of numbers or whether it also contains letters.
NB: a character c is a digit if c >= '0' && c <= '9'
Prints to the screen
"numeric text" or "NON-numeric text".

Example:
Today I'm in class >> NON-numeric text
2001: A Space Odyssey >> NON-numeric text
12345 >> numeric text

*/	



package eserciziLezione5;
import java.util.Scanner;
public class StringaNumerica {
	
	
	public static void main (String[] args) {
			
		Scanner sc = new Scanner (System.in);
		String c = "";
		
		System.out.println("Benvenuto, scrivi qualcosa (Numerico): ");
		c = sc.next();
		
		
		if (c.charAt(0) >= '0' && c.charAt(0) <= '9') {
				
				System.out.println("testo numerico");
			}
		else {
				System.out.println("testo NON numerico");
			}
		
	}

	
}
