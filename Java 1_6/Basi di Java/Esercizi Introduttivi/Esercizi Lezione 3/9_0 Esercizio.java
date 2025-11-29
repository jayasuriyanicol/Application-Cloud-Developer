/* Exercise #9 – Lotto Game
Implement a lottery game on a single wheel.
Create an array of size 5 for the wheel and randomly draw 5 numbers
between 1 and 90. Then create a second array for the player's bet: the
size will be chosen dynamically (between 1 and 5), then the player enters the numbers
he wants to play (all different and between 1 and 90).
Finally, the system will report how many numbers were guessed.
NB: Use (int)(Math.random()*90)

*/
package eserciziLezione3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Esercizio9_0 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		//Create a new lottery with 5 numbers, generated randomically
		int[] lotteria = new int[5];
		int numeriEstratti = 0;
		
		
		//Assign the numbers to the lottery, we add 'duplicato' value to check duplicates values generates
		while (numeriEstratti < 5) {
			int estratto = random.nextInt(90) + 1;
			boolean duplicato = false;
			
			
			//Verify if there is some numbers duplicated in the lottery
			for (int i = 0; i < numeriEstratti; i++) {
				if (lotteria[i] == estratto) {
					duplicato = true;
					break;
				}
			}
			
			
			
			if (!duplicato) {
				lotteria[numeriEstratti] = estratto;
				numeriEstratti++;
			}
		}
		
		
		
		
		//Insert of how many, numbers and numbers the User want to play
		int quantitaGiochi = 0;
		
		do {
			System.out.print("Benvenuto, quanti numeri vuoi giocare (da 1 a 5)? ");
			quantitaGiochi = scanner.nextInt();
			
		} while (quantitaGiochi < 1 || quantitaGiochi > 5);
		
		int[] giocata = new int[quantitaGiochi];
		int numeriInseriti = 0;
		
		System.out.println("Inserisci i tuoi " + quantitaGiochi + " numeri (1-90, diversi tra loro):");
		
		while (numeriInseriti < quantitaGiochi) {
			
			System.out.print("Numero " + (numeriInseriti + 1) + ": ");
			int input = scanner.nextInt();
			
			if (input < 1 || input > 90) {
				System.out.println("ATTENZIONE ! Il numero deve essere compreso fra tra 1 e 90.");
				continue;
			}
			
			
			
			//Manage the case, where the player re-insert the same number another time
			boolean giocato = false;
			for (int i = 0; i <	 numeriInseriti; i++) {
				if (giocata[i] == input) {
					giocato = true;
					break;
				}
			}
			
			if (giocato) {
				System.out.println("ATTENZIONE ! Non puoi inserire un numero già giocato !");
			} else {
				giocata[numeriInseriti] = input;
				numeriInseriti++;
			}
		}
		
		scanner.close();
		
		
		
		//Calculate the numbers the user found
		int indovinati = 0;
		
		for (int i = 0; i < giocata.length; i++) {
			for (int j = 0; j < lotteria.length; j++) {
				if (giocata[i] == lotteria[j]) {
					indovinati++;
				}
			}
		}
		
	
		System.out.println("Numeri Estratti: " + Arrays.toString(ruota));
		System.out.println("Numeri da te giocati:       " + Arrays.toString(giocata));
		
		
		System.out.println("Hai indovinato " + indovinati + " numeri.");
		
		
	}
}