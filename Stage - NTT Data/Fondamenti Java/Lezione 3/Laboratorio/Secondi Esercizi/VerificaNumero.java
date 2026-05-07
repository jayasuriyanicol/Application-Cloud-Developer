package Lezione_03;

public class VerificaNumero {
	
	
	static Integer numero;

	public static void main(String[] args) {
		
		System.out.println("PARI: " + isPari(10));
		System.out.println("SEGNO: " + segno(3));
		System.out.println("MULTLIPO: " + isMultiplo(3,3));
		

	}
	
	
	public static boolean isPari(int n) {
		
		if( n%2==0) {
			
			return true;
		
		}
		return false;
	}
	
	
	
	public static String segno(int n) {
		
		if(n>0) {
			
			return "positivo";
		}
		if (n==0) {
			return "zero";
		}
		
		if(n<0) {
			
			return "negativo";
		}
		
		return null;
	}
	
	
	
	public static String isMultiplo(int n, int divisore) {
		
		
		if(divisore == 3 || divisore == 5) {
			
			if(divisore== 3) {
				
				if (n%3==0) {
					
					return "Multlipo di 3";
				}
				return "Il numero non è multiplo di 3";
				} else if (divisore ==5){
					
					if (n%5==0) {
				
						return "Multlipo di 5";
					}
					return "Il numero non è multiplo di 5";
				}
			}
			
	else {
			
			System.out.println("ATTENZIONE ! è stato inseirto un divisore diverso da 3 o 5");
	}
		return null;
	}
}
	
	
	
	
