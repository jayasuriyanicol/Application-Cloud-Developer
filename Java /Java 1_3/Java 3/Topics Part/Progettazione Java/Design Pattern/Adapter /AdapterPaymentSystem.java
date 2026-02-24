'''

Descrizione soluzioneProgettare e implementare una classe Adapter che permetta di utilizzare la classe 
PaymentSystem come se fosse un PaymentProcessor.
Presentare sia la soluzione Adapter Class (che sfrutta l’ereditarietà) che quella Object (che 
sfrutta la composizione)


'''
package eserciziLezione12;

public class AdapterPaymentSystem  extends PaymentSystem implements PaymentProcessor {
    
    @SuppressWarnings("static-access")
	@Override
    public void pay(double amount) {
        int amountInCents = (int) (amount * 100);
      
        this.makePayment(amountInCents);
    }
}