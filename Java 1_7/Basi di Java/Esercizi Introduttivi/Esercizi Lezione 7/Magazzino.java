package eserciziLezione7;
import java.util.ArrayList;

public class Magazzino {
	

        private int dimensione;

		private ArrayList <Articolo> warehouse = new ArrayList <>();
		
		Magazzino(){
			
		System.out.println("Il magazzino con i PRODOTTI è stato creato con la dimensione massima di:  " + dimensione);
			
		

	}
		
   
	
	
	public int getDimensione() {
		
		return dimensione;
	
}
	

	
	public void inserisciProdotto(Articolo articolo) {
		
		warehouse.add(articolo);
		
			
		
		
	}
	
	public void rimuoviProdotto(int posizione,Articolo articolo) {
		
		
		if (posizione <= warehouse.size() && posizione >= 0) {
			
			warehouse.add(articolo);
			
		}
			
			
		
	}
	
	
	public void stampaProdotti() {
		
		if(warehouse.size() == 0) {
			
			System.out.println("\nATTENZIONE ! Il magazzino risulta essere VUOTO ");
			
		}
		
		System.out.println("Questi sono gli oggetti presenti nel MAGAZZINO : ");
		
			for (int i = 0; i < warehouse.size();i++) {
				
				System.out.println("\n OGGETTO -> " + warehouse.get(i));
		
	}

}

public void costiTotali() {
		
		if (warehouse.size() == 0) {
			
			System.out.println("\nATTENZIONE ! La somma dei costi equivale a 0. Dato che non sono presenti oggetti in MAGAZZINO ");
		
		}
		
		double costoTotale = 0;
		for (Articolo articolo : warehouse) {
			
			  
			costoTotale += articolo.prezzoVendita();
			
		}
		System.out.println("Questi sono i COSTI TOTALI del MAGAZZINO:  " + costoTotale );
	}
	
	
	
	
	
	
	
	public void ricaviTotali() {

		if (warehouse.size() == 0) {
			
			System.out.println("\nATTENZIONE ! La somma dei RICAVI TOTALI equivale a 0. Dato che non sono presenti oggetti in MAGAZZINO ");
		
		}
		
		double ricaviTotale = 0;
		for (Articolo articolo : warehouse) {
			
			  
			ricaviTotale += articolo.prezzoVendita();
			
		}
		System.out.println("Questi sono i RICAVI TOTALI del MAGAZZINO:  " + ricaviTotale );
	}
	
	
	
	public ArrayList<Articolo> ricercaPerModello(String modello) {

		ArrayList<Articolo> trovati = new ArrayList<>();

		for (Articolo art : warehouse) {


			if (art.getModello().toLowerCase().equals(modello.toLowerCase()))


				trovati.add(art);


		}
	

		return trovati;


	}


	


	@Override

	public String toString() {


		String res = "Magazzino\n";


		for (Articolo art : elencoArticoli) {
			res += art.toString() + "\n";


		}



		return res;


	}
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
