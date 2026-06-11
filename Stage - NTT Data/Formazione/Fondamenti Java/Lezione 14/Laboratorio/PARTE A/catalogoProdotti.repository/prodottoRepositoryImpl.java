package catalogoProdotti.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import catalogoProdotti.model.Prodotto;

public class prodottoRepositoryImpl implements ProdottoRepository {
	
	
	//? In this case we do not have a DB so we gonna use a simple ArrayList as a DB to add the products
	private final List<Prodotto> listaProdotti = new ArrayList<>();
	private long idCorrente = 1L;
	
	
	public prodottoRepositoryImpl() {
	
		listaProdotti.add(new Prodotto("Canguro", 12.50, 1L));
		listaProdotti.add(new Prodotto("Paletta e Secchiello", 3.50, 2L));
		listaProdotti.add(new Prodotto("Accendino", 2.20, 3L));
	}

	
	
	@Override
	public List<Prodotto> findAll() {
		
		return listaProdotti;
		
	}

	@Override
	public Optional<Prodotto> findById(Integer id) {
		
		return listaProdotti.stream() 
				
				.filter(p -> p.getId().equals(id))
				.findFirst();
		
	}

	@Override
	public void save(Prodotto prodotto) {
		
		prodotto.setId(idCorrente++);
		listaProdotti.add(prodotto);
		
	}



	@Override
	public Optional<Prodotto> findByNome(String nome) {
		
		return listaProdotti.stream() 
			
				.filter(p -> p.getNome().equals(nome))
				.findFirst();
		
	}
	
	
	
	
	

}
