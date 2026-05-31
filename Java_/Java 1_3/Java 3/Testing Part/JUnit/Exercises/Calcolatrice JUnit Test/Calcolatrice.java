package Calcolo;

/*  
    * Tamagotchi - Simple Class
    ? Adding simple class Calcolatrice to test it with JUnit

    ! 1. somma(), to sum to numbers.
    ! 2. potenzaPositiva(), to elevate pow of a number veryfing previously if the numbers ar positive.
    ! 3. dividi(), to divide the number casting it into a double, and veryfing previously if the b is positive or ZeroDivisionError.

*/
public class Calcolatrice {
	
	public int somma(int a, int b) {
		return a + b;
	}

	public int potenzaPositiva(int a, int b) throws Exception {
		if(a > 0 && b > 0)
			return (int)Math.pow(a, b);
		else
			throw new Exception("ATTENZIONE ! I numeri non sono positivi");
	}
	
	
	public double dividi(int a, int b) throws Exception {
		if(b!= 0)
			return (double)a / b;
		else 
			throw new Exception("ATTENZIONE ! Errore divisione per zero");
	} 

}
