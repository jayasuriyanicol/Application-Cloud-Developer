package Lezione_03;

public class RubricaSemplificata {
	
	static String primoNome = "Nicol";
	static String secondoNome = "Martina";
	
	static String primoTelefono= "12345";
	static String secondoTelefono = "678910";
	
	
	static String nuovoCellulare = "3210";
	
	public static void main(String[] args) {
		
		stampaContatto(primoNome, primoTelefono);
		aggiornaTelefono(primoTelefono, nuovoCellulare);
		stampaMenu();
		

	}
	
	public static void stampaContatto(String nome, String telefono) {
		
		System.out.println("NOME: " + nome );
		System.out.println("NUMERO DI TELEFONO: " + telefono);
		
	}
	
	public static void aggiornaTelefono(String vecchio, String nuovo) {
		
		if(primoNome != null && primoTelefono == vecchio) {
			
			primoTelefono = nuovo;
		}else if(secondoNome != null && secondoTelefono == vecchio) {
			
			secondoTelefono = nuovo;
		}
		else {
			System.out.println("ATTENZIONE ! Non risulta nessun teelfono corrispondete con quello vecchio oppire nome nullo.");
			
		}
	
		}
	
	public static void stampaMenu() {
		
		
		System.out.println("\nPRIMO CONTATTO\nNOME: " + primoNome);
		System.out.println("\nNUMERO TELEFONO: " + primoTelefono);
		System.out.println("\nSECONDO CONTATTO\nNOME: " + secondoNome);
		System.out.println("\nNUMERO TELEFONO: " + secondoTelefono);
	}
	

}
