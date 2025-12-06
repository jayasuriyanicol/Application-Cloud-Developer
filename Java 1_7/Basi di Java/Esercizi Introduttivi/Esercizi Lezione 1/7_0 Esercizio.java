/*Exercise #7
Read two numbers g and m from the keyboard, representing day g of month m, and calculate and print the number of days that have passed since the beginning of the year (assuming we are NOT in a leap year).
Example: I receive inputs of 1 and 2 (i.e., February 1st), so the output should be "31 days have passed since the beginning of the year" (so the day itself is not counted).
Special cases:
• Entering 1 and 1 should result in "0 days have passed since the beginning of the year."
• Entering 31 and 12 should result in "364 days have passed since the beginning of the year."
• Entering a pair of g and m that does not correspond to a real date results in an error message stating "Inconsistent day/month values."*/

package corsoBase;
import java.util.Scanner;
public class Esercizio7_0 {

	public static void main(String[] args) {
		
		int g;
		int m;
		int giorni = 0;
	
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Inserisci il giorno (g): ");
		g = scanner.nextInt();
		
		System.out.println("Inserisci il mese (m): ");
		m = scanner.nextInt();
		
		
		scanner.close();
		
		if (g==1 && m == 1) {
		    
			System.out.println("Dall'inizio dell'anno sono trascorsi 0 giorni");
			
		}
		
		
		if (g==31 && m == 12) {
				
				System.out.println("Dall'inizio dell'anno sono trascorsi 364 giorni");
			}
			
	    for (int i=1; i< m; i++) {
			if (i== 1 || i ==3 || i== 5 || i == 7 || i == 8 || i == 10 || i == 12) {
				
				giorni += 31;
				
			}
			
			if(i==2) {
				giorni += 28;
			}
			
			if(i==4 || i ==6 || i == 9 || i == 11) {
				
				giorni += 30;
	
			}
			
			
	    }
	    
	    if(g <= 31 && (m== 1 || m ==3 || m== 5 || m == 7 || m == 8 || m == 10 || m == 12) || g <= 28 && m == 2 || g <= 30 && (m==4 || m ==6 || m ==9 || m==11 )) {
	    	
	    	
	    	giorni += g;
	    	
	    	giorni --;
	    	
	    	System.out.println("Dall'inizio dell'anno sono trascorsi " + giorni + " giorni");
	    } else {
	    	
	    	System.out.println("ATTENZIONE ! Scrivere una data corretta");
	    	
	    }
	    }
			
		
	
	}

