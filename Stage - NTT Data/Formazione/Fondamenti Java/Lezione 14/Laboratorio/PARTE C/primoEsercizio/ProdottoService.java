package catalogoProdotti.service;

import java.util.List;
import java.util.Optional;

import catalogoProdotti.dto.ProdottoRequestDTO;
import catalogoProdotti.dto.ProdottoResponseDTO;
import catalogoProdotti.mapper.ProdottoMapper;
import catalogoProdotti.model.Prodotto;
import catalogoProdotti.repository.ProdottoRepository;

public class ProdottoService {
	
	
	private final ProdottoRepository pr;
	
	
	public ProdottoService(ProdottoRepository pr) {
		
		this.pr = pr;
	}
	
	
	public List<ProdottoResponseDTO> trovaTuttiProd() {
		
		return pr.findAll()
			   .stream()
			   .map(ProdottoMapper::toResponse)
			   .toList();
	}
	
	
	public ProdottoResponseDTO trovaProdId(Integer id) {
		

		Prodotto p = pr
				
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ATTENZIONE ! nessun elemento trovato con quell'ID"));
		
		return ProdottoMapper.toResponse(p);
				
					
		}
	
	
	public ProdottoResponseDTO creaProd(ProdottoRequestDTO r) {
		
	Prodotto p = ProdottoMapper.toModel(r);
	pr.save(p);
	
	return  ProdottoMapper.toResponse(p);
	
	}
	

	
	
	
	

}
