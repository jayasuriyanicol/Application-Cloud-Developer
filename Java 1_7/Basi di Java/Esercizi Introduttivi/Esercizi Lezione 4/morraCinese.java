/*



		 * Write a MorraCinese class with a main method that simulates a game of


		 * Rock-Paper-Scissors between the computer and a player. The system generates


		 * its move by randomly selecting a value between 0, 1, and 2, which corresponds


		 * to rock, paper, and scissors. The player then executes their roll by typing


		 * 0, 1, or 2 (with the same correspondence as before). The rule is that


		 * scissors wins over paper, paper wins over rock, and rock wins over scissors.


		 * 


		 * After each match, the system's and player's rolls are printed, and finally


		 * the winner's result is displayed. If the same roll is made, it's a draw. At


		 * this point, the player is asked whether to play again or quit the game.


		 */

package eserciziLezione4;

import java.util.Random;
import java.util.Scanner;

public class MorraCinese {

	public static void main(String[] args) {
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		
		//Initialite the s = number selected from user, sUt the selected option, continuo for continuing every time the match or stop it
		int s = 0;
		String sUt = "";
		int continuo = 0;
		
		
		//Form from the computer, formaPC similar to the sUt.
		do {
			int num = r.nextInt(3); 
			String formaPC = "";
			
			if (num == 0) {
				formaPC = "Sasso";
			} else if (num == 1) {
				formaPC = "Carta";
			} else {
				formaPC = "Forbici";
			}
			
			
			do {
				  System.out.println("Inserisci un numero fra:\n0 -> Sasso\n1 -> Carta\n2->Forbici");
				  s = sc.nextInt();
				  
				  if (s < 0 || s > 2) {
					  System.out.println("ATTENZIONE ! il numero deve essere compreso fra 0 e 2 COME INDICATO !");
				  }
				
			} while(s < 0 || s > 2); 
			
			
			
			//Association of sUt
			if (s == 0) {
				sUt = "Sasso";
			}
			else if (s == 1) {
				sUt = "Carta";
			}
			else sUt = "Forbici";
			
			System.out.println("\nTu hai scelto: " + sUt);
			System.out.println("Il PC ha scelto: " + formaPC);
			
			
			//Cases
			if (s == num) {
				System.out.println("Pareggio");
			} 
			else if ((s == 0 && num == 2) || (s == 1 && num == 0) || (s == 2 && num == 1)) {
				System.out.println("Hai vinto!");
			} 
			else {
				System.out.println("Ha vinto l'avversario !");
			}
			
			System.out.println("Il giocatore ha scelto " + sUt + ", mentre l'avversario ha scelto " + formaPC);
			
			
			
			//Asking 0 to terminate and 1 to continue
			do {

				System.out.println("\nATTENZIONE ! Vuoi continuare con una nuova partita\n0-> NO\n1->SI\nScelta: ");
				continuo = sc.nextInt();

				if (continuo != 0 && continuo != 1) {
					System.out.println("ATTENZIONE ! Premere 0 o 1");
				}

			} while (continuo != 0 && continuo != 1);
			
		//If is 1 we return in the beginning of the programm
		} while (continuo == 1);
		
		sc.close();
	}
}