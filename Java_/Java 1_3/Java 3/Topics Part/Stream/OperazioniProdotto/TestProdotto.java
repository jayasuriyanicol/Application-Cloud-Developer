'''
Data
Assume we have the following list:

ArrayList<Prodotto> catalogo = new ArrayList<Prodotto>();
catalogo.add(new Prodotto(133, "latte", "alimentare", 100, true, 2.5, 0));
catalogo.add(new Prodotto(134, "latte UHT", "alimentare", 0, false, 2.5, 0));
catalogo.add(new Prodotto(113, "pomodori", "alimentare", 50, true, 1.5, 5));
catalogo.add(new Prodotto(123, "libro", "media", 10, true, 10, 5));
catalogo.add(new Prodotto(155, "maglietta", "abbigliamento", 20, true, 25, 10));
catalogo.add(new Prodotto(184, "cd musicale", "media", 0, false, 12.5, 0));
catalogo.add(new Prodotto(143, "smartphone", "elettronica", 80, true, 250, 10));
catalogo.add(new Prodotto(144, "cuffie", "elettronica", 0, false, 250, 10));


Operations
Write a class that uses Java 8 streams to get:
1. the number of categories
2. the categories sorted alphabetically, without duplicates
3. the product names sorted by ascending price
4. the products sorted by discount
5. the product with the highest discount
6. the sum of the food product prices
7. an empty Optional following a product search for a non-existent category (e.g., toys)
8. the product with the highest price in the middle category
9. the names of unavailable products
+
'''



package eserciziLezione12;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.*;
import java.util.List;
import java.util.Optional;

public class TestProdotto {

	public static void main(String[] args) {
		
		
		ArrayList<Prodotto> catalogo = new ArrayList<Prodotto>();
		catalogo.add(new Prodotto(133, "latte", "alimentare", 100, true, 2.5, 0));
		catalogo.add(new Prodotto(134, "latte UHT", "alimentare", 0, false, 2.5, 0));
		catalogo.add(new Prodotto(113, "pomodori", "alimentare", 50, true, 1.5, 5));
		catalogo.add(new Prodotto(123, "libro", "media", 10, true, 10.0, 5));
		catalogo.add(new Prodotto(155, "maglietta", "abbigliamento", 20, true, 25.0, 10));
		catalogo.add(new Prodotto(184, "cd musicale", "media", 0, false, 12.5, 0));
		catalogo.add(new Prodotto(143, "smartphone", "elettronica", 80, true, 250.0, 10));
		catalogo.add(new Prodotto(144, "cuffie", "elettronica", 0, false, 250.0, 10));
		
		
	
		
		//1. il numero di categorie
		long numeroCategorie =  catalogo.stream()
				   .map(p-> p.getCategoria())
				   .distinct()
				   .count();
		System.out.println("1. Il numero di categorie è :" + numeroCategorie);
		
		
		
		//2.le categorie ordinate in ordine alfabetico, senza elementi doppi
		
			System.out.println("\n2. Le categorie ordinate senza doppioni: ");
						catalogo.stream()
								.map(p -> p.getCategoria())
								.distinct()
								.sorted()
								.forEach(c -> System.out.println(c));
		
		//3. i nomi dei prodotti ordinati per prezzo crescente
						
			System.out.println("\n3. Prodotti ordinati prezzo CRESCENTE: ");
						
			catalogo.stream()
				.sorted(Comparator.comparingDouble(p -> p.getPrezzo()))
				.map(p-> p.getDescrizione())
				.forEach(p -> System.out.println(p));
			
		//4. i prodotti ordinati in base allo sconto
			
			System.out.println("\n4. Prodotti ordinati per SCONTO:  ");
			
			catalogo.stream()
				.sorted(Comparator.comparingInt(ps -> ps.getPercentuale()))
				.forEach(ps -> System.out.println(ps));
			
		//5. Il prodotto con lo sconto maggiore
			
			System.out.println("\n5. Prodotto con lo  SCONTO MAGGIORE (MAX):  ");
			
			catalogo.stream()
				.max(Comparator.comparingInt(sm -> sm.getPercentuale()))
				.ifPresent(sm -> System.out.println(sm));
			
		//6. Somma dei prezzi dei prodotti alimentari
			
			double sommaPrezzi = catalogo.stream()

					.filter(pa -> pa.getCategoria().equals("alimentare"))
					.mapToDouble(pa -> pa.getPrezzo())
					.sum();
					
			System.out.println("\n6. Somma PREZZI ALIMENTARI :  " + sommaPrezzi);
			
		//7. Un Optional vuoto a seguito di una ricerca di prodotto per una categoria inesistente (es. giocattoli)
			
			Optional<Prodotto> ricercaProdottoCatInesistente = catalogo.stream()
					.filter(pci -> pci.getCategoria().equals("alimentari"))
					.findFirst();
			System.out.println("\n7. Prodotto Categoria INESISTENTE :  " + ricercaProdottoCatInesistente);
			
		
			
			
			
		//8. Il prodotto con prezzo più alto nella categoria media
			System.out.println("\n8. Prodotto più CARO nella MEDIA :  ");
			
			catalogo.stream()
                .filter(p -> p.getCategoria().equals("media"))
				.max(Comparator.comparingDouble(pc -> pc.getPrezzo()))
				.ifPresent(pc -> System.out.println(pc.getDescrizione()));

				
		//9. I nomi dei prodotti non disponibili
			
            System.out.println("\n9. Prodotto NON DISPONIBILE :  ");
			catalogo.stream()	
				.filter(pnd -> !pnd.getDisponibilita())
				.map(pnd -> pnd.getDescrizione())
	            .forEach(pnd -> System.out.println(pnd));
			
					
				
			
	
			
		
		
		
		
		
		
		
		
		
		
		

	}



}
