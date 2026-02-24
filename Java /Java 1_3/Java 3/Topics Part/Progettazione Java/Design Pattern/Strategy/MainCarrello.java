package eserciziLezione13;

public class MainCarrello {

	public static void main(String[] args) {
		
		Carrello c1 = new Carrello();
		
		Prodotto p1 = new Prodotto("Latte", 4, 1.20);
		Prodotto p2 = new Prodotto("Pizza Rossa", 2, 4.50);
		Prodotto p3 = new Prodotto("Forbici", 1, 3.90);
		Prodotto p4 = new Prodotto("Fagiolini", 2, 1.40);
		
		c1.aggiungiProdotto(p1);
		c1.aggiungiProdotto(p2);
		c1.aggiungiProdotto(p3);
		c1.aggiungiProdotto(p4);
		
		double tot = c1.calcolaTotale(new interfaceEstivi());
		
        System.out.println("Il totale scontato (Invernali) è: € "  + String.format("%.2f", tot));
    }
		
	
	}


