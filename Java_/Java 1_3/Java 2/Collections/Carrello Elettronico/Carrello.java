package eserciziLezione10;


import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Comparator;



public class Carrello {
	
	private ArrayList<Prodotti> carrello = new ArrayList<>();
	
	
	public void aggiungiProdotto(Prodotti prod) {
		
		carrello.add(prod);

	}
	
	
	public void rimuoviProdotto(Prodotti prod) {
		
		carrello.remove(prod);
		
	
	}
	
	public Double prezzoTotale() {
		
		
		Double prezzo = 0.0; 
		for(Prodotti p: carrello ) {
			
			prezzo += p.getPrezzoaVendita();
			
		}
		
		return prezzo;
		
	}
	
	
	public TreeSet<Prodotti> articoliPrezzoCresc() {
		
		TreeSet<Prodotti> treeSet = new TreeSet<>(new Comparator<Prodotti> () {
		
			@Override
			public int compare(Prodotti p1, Prodotti p2) {
				
				int ris = p1.getPrezzoaVendita().compareTo(p2.getPrezzoaVendita());
				if (ris==0) {
					return p1.getId().compareTo(p2.getId());
				}
				
				return ris;
			}
	});
		
		treeSet.addAll(carrello);
		return treeSet;
		
	}
		
		

	
	
	
	public TreeSet<Prodotti> tempiConsegna() {
		
		TreeSet<Prodotti> treeSet = new TreeSet<>(new Comparator <Prodotti>() {
			
			@Override
			public int compare(Prodotti p1, Prodotti p2) {
				
				int ris = Integer.compare(p1.getTempiSpedizione(),p2.getTempiSpedizione());
					
					if(ris==0) {
						
						return p1.getId().compareTo(p2.getId());
					}
				
				return ris;
			}
			
			});
			
			treeSet.addAll(carrello);
			return treeSet;
			
			
			
		}
		
		
	
	
	public Prodotti prodottoCaro() {
		
		Prodotti max= carrello.get(0);
		for(Prodotti p: carrello) {
			
			if(p.getPrezzoaVendita() > max.getPrezzoaVendita()) {
				
				max = p;
		
				
			}
			
			
		}
		
		return max;
		
	}
	
	
   public Prodotti proddotoMenoCaro() {
	   
	   
	   if(carrello.isEmpty()) {
		   
		   return null;
	   }
		
		Prodotti min= carrello.get(0);;
		for(Prodotti p: carrello) {
			
			if(p.getPrezzoaVendita() < min.getPrezzoaVendita()) {
				
				min = p;
				
				
			}
			
			
		}
		
		return min;
		
	}
	
	
	
	
	
	
	

}
