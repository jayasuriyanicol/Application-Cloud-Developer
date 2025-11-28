/*
 * Write a Java class with a main method that calculates the hours and minutes remaining until the end of class.

Version 1: Assume that class ends at 6:00 PM.
Version 2: Allow the user to enter the end time (acquiring the hours and minutes with two separate readings).

Note: Use two objects of type java.util.Date.
 */

package eserciziLezione4;

import java.util.Date;
import java.util.Scanner;

public class differenzaDate {

    public static void main(String[] args) {

    	//First Version, adding the case already known date
        System.out.println("PRIMA VERSIONE 1 ");
        
        Date dataInizio = new Date(); 
        Date dataFine  = new Date(); 
        
        dataFine.setHours(19); 
        dataFine.setMinutes(30);
        dataFine.setSeconds(00);

        int ora = dataFine.getHours() - dataInizio.getHours();
        int minuti = dataFine.getMinutes() - dataInizio.getMinutes();
        int secondi = dataFine.getSeconds() - dataInizio.getSeconds();
        
        
        //We manage the case if the time is already gone, to evitate the form (-number) 
        if (secondi < 0) {
            minuti--;
            secondi += 60;
        }
        if (minuti < 0) {
            ora--;
            minuti += 60;
        }

        System.out.println("Data di inizio: " + dataInizio);
        System.out.println("Data di fine:   " + dataFine);
        
        
        //We manage the case of out of time,  if the time exceed the fine
        if (ora >= 0) {
             System.out.println("Tempo Restante: " + ora + " ore " + minuti + " minuti " + secondi + " secondi");
        } else {
             System.out.println("Tempo Restante: ATTENZIONE ! La data di fine è già passata.");
        }

        
      //Second Version, adding the case where the user need to set the number
        System.out.println("\nSECONDA VERSIONE 2");
        
        Scanner scanner = new Scanner(System.in);
        
        Date dataInizio2 = new Date(); 
        
        System.out.println("Dammi l' ora in maniera INT: ");
        int oraInput = scanner.nextInt();
        System.out.println("Dammi i minuti in maniera INT: ");
        int minutiInput = scanner.nextInt();
        
        Date dataFine2  = new Date();
        dataFine2.setHours(oraInput);
        dataFine2.setMinutes(minutiInput);
        dataFine2.setSeconds(0);
		
		int ora2 = dataFine2.getHours() - dataInizio2.getHours();
		int minuti2 = dataFine2.getMinutes() - dataInizio2.getMinutes();
		int secondi2 = dataFine2.getSeconds() - dataInizio2.getSeconds();

        if (secondi2 < 0) {
            minuti2--;
            secondi2 += 60;
        }
        if (minuti2 < 0) {
            ora2--;
            minuti2 += 60;
        }
		
		System.out.println("Data di inizio: " + dataInizio2);
		System.out.println("Data di fine:   " + dataFine2);
		
		if (ora2 >= 0) {
            System.out.println("Tempo Restante: " + ora2 + " ore " + minuti2 + " minuti " + secondi2 + " secondi");
        } else {
            System.out.println("Tempo Restante: La data di fine è già passata.");
        }
		
        scanner.close();
    }
}
