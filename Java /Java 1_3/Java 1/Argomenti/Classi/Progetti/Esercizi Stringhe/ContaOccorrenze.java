/*
4) Count Occurrences

Write a program that, given a string and a character as input, prints the number of occurrences of the character in the string.
Write two implementations, using the following techniques:
Use the charAt(int) method
Use the indexOf(char, int) method

Example:
aaabbbccc, b >> 3 occurrences
aaabbbccc, x >> 0 occurrences
abcabcabc, a >> 3 occurrences
 
 */


package eserciziLezione5;
import java.util.Scanner;
public class ContaOccorrenza {

	public static void main(String[] args) {
		
		String s = "";
        String o;
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Benvenuto, inserisci una parola: ");
		s = sc.next();
		
		System.out.println("Inserisci, un'occorrenza: ");
		o = sc.next();
		
		
		
		
		//Implementation with the method charAt, iterating and comparing the char with the occurence
		
		int cont = 0;
		String c;
		for(int i=0; i<s.length(); i++) {
		
			c = Character.toString(s.charAt(i));
			if(c.equals(o)) {
				
				cont ++;
				
			}
			
			
		}
		
		System.out.println("Occorrenze con il metodo 'charAt' : "+ cont);
		
		
		
		
		//Implementation with the method indexOf, selection of the pos of the charAt and keeping the index of the pos.
		char pos = o.charAt(0);
		int cont1 = 0;
		
		int indice = s.indexOf(pos,0);
			
		
		//Cicling until, we don't get a letter (occurance). We have to remember that  if there isn't a indive the console go to print '-1'
		while(indice != -1) {
			cont1 ++;
			
			//To don't get the same number, we go to skip the found number and continue to cicling
			indice = s.indexOf(pos, indice +1);
		}
			
		  System.out.println("Occorrenze con il metodo 'IndexOf' " + cont1);
		
		
		
	}

}
