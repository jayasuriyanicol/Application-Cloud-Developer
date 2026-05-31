package eserciziLezione10;

public class MainCarrelloElettronico {

		public static void main(String[] args) {
			
			Carrello mioCarrello = new Carrello();
			Prodotti prod1 = null;
			try {
				prod1 = new Prodotti("1", "Samsung", "Galaxy S23", 799.99, 3);
			} catch (Error e) {

				e.printStackTrace();
			}

			try {
				mioCarrello.aggiungiProdotto(prod1);
				mioCarrello.aggiungiProdotto(new Prodotti("2", "Apple", "iPhone 15", 1099.99, 2));
				mioCarrello.aggiungiProdotto(new Prodotti("3", "Sony", "PlayStation 5", 499.99, 5));
				mioCarrello.aggiungiProdotto(new Prodotti("4", "Microsoft", "Xbox Series X", 499.99, 4));
				mioCarrello.aggiungiProdotto(new Prodotti("5", "Dell", "XPS 13", 1199.99, 7));
				mioCarrello.aggiungiProdotto(new Prodotti("6", "HP", "Spectre x360", 1299.99, 6));
				mioCarrello.aggiungiProdotto(new Prodotti("7", "LG", "OLED TV", 1499.99, 8));
				mioCarrello.aggiungiProdotto(new Prodotti("8", "Bose", "QuietComfort 45", 329.99, 3));
				mioCarrello.aggiungiProdotto(new Prodotti("9", "Canon", "EOS R6", 2499.99, 5));
				mioCarrello.aggiungiProdotto(new Prodotti("10", "GoPro", "Hero 12", 399.99, 2));
				mioCarrello.aggiungiProdotto(new Prodotti("10", "GoPro2", "Stesso codice", 399.99, 2));
			} catch (Error err) {
				System.err.println("Errore nella creazione del prodotto: " + err.getMessage());
			}

			System.out.println("\n" + mioCarrello);

			System.out.println("====== Ordino i prodotti per prezzo ======");
			for (Prodotti prod : mioCarrello.articoliPrezzoCresc()) {
				System.out.println(prod);
			}

			System.out.println("\n====== Ordino i prodotti per consegna ======");
			for (Prodotti prod : mioCarrello.tempiConsegna()) {
				System.out.println(prod);
			}

			System.out.println(new Carrello().proddotoMenoCaro()); // restituisce null

			System.out.println();
			try {
				mioCarrello.rimuoviProdotto(prod1);
				mioCarrello.rimuoviProdotto(new Prodotti("1568", "Non esisto", "2dd", 399.99, 2));
			} catch (Error err) {
				System.err.println("Errore nella rimozione del prodotto: " + err.getMessage());
			}
			
			System.out.println("\nArticolo più caro: " + mioCarrello.prodottoCaro());
			
			System.out.println("\nArticolo meno caro: " + mioCarrello.proddotoMenoCaro());
			
			System.out.println("\nTotale: " + mioCarrello.prezzoTotale());
		}
	}
	
	
	
	
