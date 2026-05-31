package eserciziLezione7;

public class MainCartoleria {

	public static void main(String[] args) {
		
		Magazzino magazzino = new Magazzino();
		
		Gomme g1 = new Gomme("FIBERCAP", "A", 2.30, "Rotonda", 4.99);
		Gomme g2 = new Gomme("ASTRAL", "A+", 3.10, "Cubica", 5.99);
		
		
		
		Penne p1 = new Penne("UniGravity", "Indelebile", 1.30, "Nera");
		Penne p2 = new Penne("Faghilli", "Punta in Grafite", 2.10, "Nera");
		Penne p3 = new Penne("Barilli", "Punta Sferica", 3.99, "Blu");
		
		magazzino.inserisciProdotto(g1);
		magazzino.inserisciProdotto(g2);
		magazzino.inserisciProdotto(p1);
		magazzino.inserisciProdotto(p2);
		magazzino.inserisciProdotto(p3);
		
		
		
		System.out.println(magazzino);
		
		
		System.out.println("\nRICERCA ARTICOLO -> 'Indelebile': ");
		System.out.println(magazzino.ricercaPerModello("Indelebile"));
		
		
		System.out.println("-> " + magazzino.costiTotali());
		System.out.println("-> " + magazzino.ricaviTotali());
		

		
		
		
		

	}

}
