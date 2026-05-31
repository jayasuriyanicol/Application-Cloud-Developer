package Lezione_09;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdottoRepository {
	
	private final List<Prodotto> databaseProdotti = new ArrayList<>();

	
	public ProdottoRepository() {
		
		databaseProdotti.add(new Prodotto(1,"Mago Merlino", 12.00));
		databaseProdotti.add(new Prodotto(2,"Assert False", -104.00));
		databaseProdotti.add(new Prodotto(1,"Exception Handler", 404.04));
		
	}
	
	public Optional<Prodotto> findById(Integer id) {
		
		for(Prodotto p : databaseProdotti) {
			
			if(p.id() == id) {
				
				return Optional.of(p);
			}
			
			
		}
		return Optional.empty();
	
	}
	
	
	public Optional<Prodotto> findByName(String nome){
		
		for(Prodotto p: databaseProdotti) {
			
			if(p.nome().equals(nome)) {
				
				return Optional.of(p);
				
		 	}
			
			
		}
		
		return Optional.empty();


	}
	
	
	
}
