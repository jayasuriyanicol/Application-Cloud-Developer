package Lezione_06;

public class MainMetodoPagamento {
	
	public static void main(String[] args) {
		
		MetodoPagamento p1 = new Carta("4032 3232 3123 424", "Mario Mela","IT3113JDJDI23242JFD");
        MetodoPagamento p2 = new Paypal("giacomoCoccodrillini12@gmail.com","4032 3232 3123 424");
        MetodoPagamento p3 = new Bonifico("4032 3232 3123 424","IT3113JDJDI23242JFD");
        
	
        pagamento(p1);
        pagamento(p2);
        pagamento(p3);
	}
	
        public static void pagamento(MetodoPagamento m) {
        	
        	if(m instanceof Carta c) {
        		
        		System.out.println("CARTA: " + c.getNumeroCarta());
        	}
        	
        	else if (m instanceof Paypal p) {
                System.out.println("Pagamento con PAYPAL: Account " + p.getEmail());
            } 
            else if (m instanceof Bonifico b) {
                System.out.println("Pagamento con BONIFICO: IBAN " + b.getIBAN());
            }
        }
	}

        
        
