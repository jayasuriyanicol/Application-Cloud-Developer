/*
 Create a class with the main command in which a number between 1 and 10 is randomly drawn and the user must guess it.
The user enters the number and the system responds with one of these sentences:
Too small, try again with a larger number
Too large, try again with a smaller number
Correct! You guessed correctly with N guesses.
The system calculates and stores the number of guesses and prints it at the end.
Note: For the random draw, use java.util.Random
 
 */

package eserciziLezione4;
import java.util.Random;
import java.util.Scanner;

public class guessNumber {
	
	public static void main(String[] args) {
		
		//Initialize, the inputNum (User number) and the nTent(numbers of attempts), creating the n (random variable)
		int inputNum = 0;
		int nTent = 1;
		Random n = new Random();
		Scanner scanner = new Scanner(System.in);
		
		//I initialize num with a range from (1,11), to eleven because we always consider the 10th number (+1)
		int num = n.nextInt(1,11);
		
		
		
		//I implemented it with a do while, in order to the user to guess the number until it guess it, adding the nTent for the attemps.
		do {
			
			System.out.println("\nBenvenuto inserisci un numero da 1 a 10: ");
			inputNum = scanner.nextInt();
		
				if (inputNum>num) {
					System.out.println("\nTroppo grande, riprova con un numero minore");
					nTent += 1;
					
				}
				if(inputNum<num) {
					
					System.out.println("\nTroppo piccolo, riprova con un numero maggiore");
					nTent += 1;
					
				}
				if (inputNum == num) {
					
					System.out.println("\nEsatto! Hai indovinato con "+ nTent+ " tentativi");
					break;
					
					
				}
		}while(inputNum > num || inputNum< num);
		
	}

		
}
