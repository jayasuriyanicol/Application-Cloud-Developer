package Lezione_09;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainCoppiaGenerica {

	
	public static void main(String[] args) {
		
		Coppia<String,Integer> c1 = new Coppia<>("Giacomo",67);
		Coppia<Integer,Double> c2 = new Coppia<>(1,67.76);
	    
		String[] nomi = {"Nicol","Leandro","Cristiano"};
		Integer[] soldi = {10,20,30};
		
		List<Integer> listaInt = new ArrayList<>();
		List<Double> listaDbl = new ArrayList<>();
		List<Long> listaLng = new ArrayList<>();
		
		
		List<Integer> listaIntRiemp = new ArrayList<>();
		List<Number> listaNubRiemp = new ArrayList<>();
		
		
		ProdottoRepository pr = new ProdottoRepository();

		
		listaInt.add(1);
		listaInt.add(2);
		listaInt.add(3);
		
		listaDbl.add(1.0);
		listaDbl.add(2.0);
		listaDbl.add(3.0);
		
		listaLng.add(1L);
		listaLng.add(2L);
		listaLng.add(3L);
	
		
		
		
		
		
		System.out.println("\nPrima coppia generica -> " +c1);
		System.out.println("\nSeconda coppia generica -> "+c2);
		
		System.out.println("\nPrimo elem prima coppia-> " +c1.getPrimo());
		System.out.println("\nSeconda elm seconda coppia -> "+c2.getSecondo());
		
		Coppia.swap(nomi, 1, 0);
		Coppia.swap(soldi, 2, 1);
		
		
		System.out.println("\nSTAMPA NOMI:");
		for(String s: nomi) {
			
			System.out.println("\nNome:"+ s);
		}
		
		System.out.println("\nSTAMPA SOLDI:");
		for(Integer i: soldi) {
			
			System.out.println("\nSoldi:"+ i);
		}
		
		
		Double sommaInt = Coppia.sommaTutti(listaInt);
		Double sommaDbl = Coppia.sommaTutti(listaDbl);
		Double sommaLng = Coppia.sommaTutti(listaLng);
		
		
		System.out.println("\nSTAMPA INT: " + sommaInt);
		

		System.out.println("\nSTAMPA DOUBLE: " + sommaDbl);
		
		
		System.out.println("\nSTAMPA LONG: " + sommaLng);
		
		
		 Coppia.riempi(listaIntRiemp, 3);
		 Coppia.riempi(listaNubRiemp,4);
		
		
		System.out.println("RIEMPI INT -> " + listaIntRiemp);
		System.out.println("RIEMPI NBM -> " + listaNubRiemp);
		
		
		
		
		Optional<Prodotto> t1 = pr.findById(1);
		Optional<Prodotto> t2 = pr.findByName("Juan");
		Optional<Prodotto> t3 = pr.findByName("Nicolas");
		
		
		t1.ifPresent(p -> System.out.println("SUCCESSO ! Prodotto trovato con successo " + p.nome()));
		
		Prodotto erMitico = t2.orElse(new Prodotto(99,"Cicalone",12.02));
		System.out.println("Sostituto con: " + erMitico.nome());
		
		
		Prodotto erNinja = t3.orElseThrow(() -> new IllegalArgumentException("Ao ! Ma chi ti  credi d'esse?"));
        System.out.println("C'è qualcuno di ambiguo qui !" + erNinja );		
	}
}
