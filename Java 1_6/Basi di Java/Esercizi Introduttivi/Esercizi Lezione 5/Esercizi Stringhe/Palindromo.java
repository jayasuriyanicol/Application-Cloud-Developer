/*
3) Palindrome

Write a program that reads a string from the keyboard and indicates whether the entered string is a palindrome, that is, whether it contains the same sequence of characters, reading it from the right and from the left.
Solution technique:
Create a reversed copy of the string
Examples of palindromic strings:
anna >> palindrome
itopinonavevanonipoti >> palindrome

*/



package eserciziLezione5;
import java.util.Scanner;
public class Palindromo {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		String c;
		String c1 = "";
		
		System.out.println("Banvenuto, inserisci una parola PALINDROMA: ");
		c = sc.next();
		
		
		
		for (int i = c.length() - 1; i >=0; i--) {
			
			c1 += c.charAt(i);
		}
		
		
		if (c.equals(c1)) {
			
			System.out.println("palindromo");
		}
		else {
			
			System.out.println("NON palindromo");
		}
		

	}

}
