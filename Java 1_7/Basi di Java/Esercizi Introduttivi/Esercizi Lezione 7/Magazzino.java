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

public String costiTotali() {
		
		if (warehouse.size() == 0) {
			
			System.out.println("\nATTENZIONE ! La somma dei costi equivale a 0. Dato che non sono presenti oggetti in MAGAZZINO ");
		
		}
		
		double costoTotale = 0;
		for (Articolo articolo : warehouse) {
			
			  
			costoTotale += articolo.getCosto();
			
		}
		String testoFormattato = String.format("Questi sono i COSTI TOTALI del MAGAZZINO: %.2f%n", costoTotale );
		
		return testoFormattato;
	}
	
	
	
	
	
	
	
	public String ricaviTotali() {

		if (warehouse.size() == 0) {
			
			System.out.println("\nATTENZIONE ! La somma dei RICAVI TOTALI equivale a 0. Dato che non sono presenti oggetti in MAGAZZINO ");
		
		}
		
		double ricaviTotale = 0;
		for (Articolo articolo : warehouse) {
			
			  
			ricaviTotale += articolo.prezzoVendita();
			
		}
		
       String testoFormattato2 = String.format("\nQuesti sono i RICAVI TOTALI del MAGAZZINO:  %.2f%n" , ricaviTotale );
		
		return testoFormattato2;
		

	}
	
	
	
	public ArrayList<Articolo> ricercaPerModello(String modello) {

		ArrayList<Articolo> trovati = new ArrayList<>();

		for (Articolo articolo : warehouse) {


			if (articolo.getModello().toLowerCase().equals(modello.toLowerCase()))


				trovati.add(articolo);


		}
	

		return trovati;


	}




	@Override
	public String toString() {

		String magazzino= "MAGAZZINO\n";


		for (Articolo articolo : warehouse) {
			
			magazzino += articolo.toString() + "\n";


		}
		return magazzino;
	}


	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
