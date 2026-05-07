package Lezione_03;

public class AnalizzatoreNumeri {

	public static void main(String[] args) {
		
		stampaReportNumero(5);
	
	}
	
	public static boolean isPari(int n) { return n%2==0;}
	public static boolean isPositivo(int n) {return n >0; }
	public static int massimo(int a,int b) {return a>b ?  a:b;}
    public static int minimo(int a,int b) {return a < b ? a:b;}
    
    
    public static void stampaReportNumero(int numero) {
    	
    	System.out.println("Il numero è PARI: " + (isPari(numero) ? "Si" : "No"));
    	System.out.println("Il numero è POSITIVO: " + (isPositivo(numero) ? "Si" : "No"));
    	
    	
    }
  
}
