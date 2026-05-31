package catalogoProdotti.mapper;

import catalogoProdotti.dto.ProdottoRequestDTO;
import catalogoProdotti.dto.ProdottoResponseDTO;
import catalogoProdotti.model.Prodotto;

public class ProdottoMapper {
	
	
	public static ProdottoResponseDTO toResponse(Prodotto p) {
		
		return new ProdottoResponseDTO(
				
				p.getId(),
				p.getNome(),
				p.getPrezzo()

		);
	}
	
	
	
	public static Prodotto toModel(ProdottoRequestDTO r) {
		
		
		return new Prodotto(
			
			r.nome(),
			r.prezzo(),
			null
			
				);
		
		
	}
		
		
		
	}
	
	


