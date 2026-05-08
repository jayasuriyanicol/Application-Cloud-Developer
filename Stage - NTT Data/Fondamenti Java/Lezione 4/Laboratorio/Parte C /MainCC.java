package Lezione_04;

public class MainCC {
	
	public static void main(String[] args) {
	ContoCorrente c1 = new ContoCorrente("Nicol Jayasuriya",323.56);
	ContoCorrente c2 = new ContoCorrente("Francesco Bianchi",422.43);
	
   
    c1.deposita(10);
	c1.deposita(-10);
	
	c2.deposita(20);
	c2.preleva(20);
	
	System.out.println("SALDO C1: " + c1.getSaldo());
	System.out.println("SALDO C2: " + c2.getSaldo());
	
	
	
}

}