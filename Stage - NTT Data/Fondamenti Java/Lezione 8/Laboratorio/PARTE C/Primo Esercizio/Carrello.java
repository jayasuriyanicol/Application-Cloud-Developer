package Lezione_07;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
	
	public static void main(String[] args) {
		
		List<Prodotto> listaProdotti = new ArrayList<>();
		
		Prodotto p1 = new Prodotto("Castagne", "Castagne generiche", 23.00);
		Prodotto p2 = new Prodotto("Guanti", "Guanti in lattice", 10.00);
		Prodotto p3 = new Prodotto("Biscotti Mulino Bianco", "Biscotti della Mulino Bianco, gusto cacao", 3.45);
		
		
		listaProdotti.add(p1);
		listaProdotti.add(p2);
		listaProdotti.add(p3);
		
		
		for(Prodotto p: listaProdotti) {
			
			
			System.out.println(p.toString());
		}
		
	
		
	}
	
}
