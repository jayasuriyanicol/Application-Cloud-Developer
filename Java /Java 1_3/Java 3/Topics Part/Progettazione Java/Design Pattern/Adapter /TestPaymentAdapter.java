'''
Scrivere infine una classe Main che dimostri il corretto funzionamento della soluzione.
'''

package eserciziLezione12;

public class TestPaymentAdapter {

	public static void main(String[] args) {
		
		        double amountToPay = 25.50;

		        System.out.println("TEST PaymentAdapter - EREDITARIETÀ");
		        
		        PaymentProcessor classAdapter = new AdapterPaymentSystem();
		        classAdapter.pay(amountToPay);

		        System.out.println("\nTEST PaymentAdapter - COMPOSIZIONE");
		       
		        @SuppressWarnings("unused")
				PaymentSystem existingSystem = new PaymentSystem();
		        PaymentProcessor objectAdapter = new AdapterPaymentSystem();
		        objectAdapter.pay(amountToPay);
		    }
		
	}

