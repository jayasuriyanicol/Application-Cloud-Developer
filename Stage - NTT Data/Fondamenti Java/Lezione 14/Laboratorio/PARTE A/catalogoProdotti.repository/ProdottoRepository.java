package catalogoProdotti.repository;
import java.util.List;
import java.util.Optional;

import catalogoProdotti.model.Prodotto;

public interface ProdottoRepository {
	
	
   List<Prodotto> findAll();
	
	Optional<Prodotto> findById(Integer id);
	Optional<Prodotto> findByNome(String nome);
	
	void save(Prodotto prodotto);

	
	
}
