'''

Il sistema deve ora integrare una libreria esterna, il cui codice non può essere modificato, rappresentata dalla classe seguente:
public class PaymentSystem {
    public void makePayment(int amountInCents) {
        System.out.println("Pagamento effettuato: " + amountInCents + " centesimi");
}
}


'''
package eserciziLezione12;

public class PaymentSystem {
	
	public static void makePayment(int amountInCents) {
		
		System.out.println("Pagamento effettuato: " + amountInCents + " centesimi");
	}

}
