/*
 
 2) Date Conversion

The program reads a string from the keyboard and interprets it as a date.
The format must be DD/MM/YYYY (do not perform format checks).
It then extracts the various fields (day, month, and year), converting them into numeric format, and finally prints the results to the screen.

The month must be printed in text format:
1 will be January, 2 will be February, and so on.

Example:
12/05/2022 >> 12 May 2022


 */


package eserciziLezione5;

import java.util.Scanner;
public class ConversioneData {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		String c = "";
		String s1, s2, s3;
		
		System.out.println("Benvenuto, inserisci una data in formato (GG/MM/AAAA): ");
		c = sc.next();
		
		
		s1 = c.substring(0,2);
		s2 = c.substring(3,5);
		s3 = c.substring(6,10);
		
		int giorno = Integer.parseInt(s1);
	    int mese = Integer.parseInt(s2);
	    int anno = Integer.parseInt(s3);
		
	    
	    switch (mese) {
	    
	    
	    case 1:
	    	
	    	System.out.println(s1 + " Gennaio " + s3);
	    	
	    	break;
	    
	    case 2: 
	    		
	    	System.out.println(s1 + " Febbraio " + s3);
	    	
	    	break;
	    case 3: 
    		
	    	System.out.println(s1 + " Marzo " + s3);
	    	
	    	break;
	    case 4: 
    		
	    	System.out.println(s1 + " Aprile " + s3);
	    	
	    	break;
	    case 5: 
    		
	    	System.out.println(s1 + " Maggio " + s3);
	    	
	    	break;
	    	
	    case 6: 
    		
	    	System.out.println(s1 + " Giugno " + s3);
	    	
	    	break;
	    case 7: 
    		
	    	System.out.println(s1 + " Luglio " + s3);
	    	
	    	break;
	    	
	    case 8: 
    		
	    	System.out.println(s1 + " Agosto " + s3);
	    	
	    	break;
	    	
	    case 9: 
    		
	    	System.out.println(s1 + " Settembre " + s3);
	    	
	    	break;
	    case 10: 
    		
	    	System.out.println(s1 + " Ottobre " + s3);
	    	
	    	break;
	    case 11: 
    		
	    	System.out.println(s1 + " Novembre " + s3);
	    	
	    	break;
	    case 12: 
    		
	    	System.out.println(s1 + " Dicembre " + s3);
	    	
	    	break;
	    	
	    	
	    	
	    }
	    
		
	
		
		
		
	}

}
