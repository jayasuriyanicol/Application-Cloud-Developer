package it.demo.catalogo.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import it.demo.catalogo.dto.ProdottoDTO;

//@FeignClient("MM--WR-Stream")
@FeignClient("MM-catalogo-WR")
public interface ProdottoWRFeignClient {

      //Methods used to call the endpoints of the Catalogo Microservice
		@PostMapping(path="/prodotti/registraProd", produces ="application/json", consumes="application/json")
		public void registraProdotto(@RequestBody ProdottoDTO prodotto);
		
		@GetMapping(path="/prodotti/visualizzaProd/{idProdotto}", produces="application/json")
		public ProdottoDTO getProdotto(@PathVariable Integer idProdotto);

		
		@GetMapping(path="/prodotti/visualizzaListProd",  produces="application/json")
		 public List<ProdottoDTO> getProdottiList();
		
		@GetMapping(path="/prodotti/visualizzaVersProd/{idProdotto}",  produces="application/json")
		public int getVersionProdotto(@PathVariable Integer idProdotto);
		 
		@PatchMapping(path="/prodotti/modificaQuanProd/{idProdotto}/{nuovaQuantita}",  produces="application/json")
		public ProdottoDTO modificaQuantita(@PathVariable Integer idProdotto, @PathVariable Integer nuovaQuantita);
			 
		
		 @DeleteMapping(path="/prodotti/eliminaProd/{idProdotto}", produces="application/json")
		 ProdottoDTO eliminaProdotto(@PathVariable Integer idProdotto);
		
		
		
		
		
		
	}


	
	


