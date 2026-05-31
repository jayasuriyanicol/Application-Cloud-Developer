package com.spring.ecommerce.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ecommerce.dto.ManagementProductDTO;
import com.spring.ecommerce.service.ProductServiceInterface;
import com.spring.ecommerce.dto.ProductResponseDTO;

/* * EcommerceProductsController - Product Catalog API
    ? A dedicated REST controller focused on the management and discovery of products. It provides the external interface for catalog administration and product retrieval, isolating product-specific logic from order processing.

    ! 1. Administrative Input, utilizes 'ManagementProductDTO' for adding new items. This separation of concerns ensures that the internal data required for product creation (like initial stock levels) is handled through a specific channel distinct from general viewing.
    ! 2. Resource Discovery, implements endpoints for both specific lookup (by ID) and bulk retrieval. By returning 'ProductResponseDTO', it ensures that sensitive or unnecessary internal product fields are filtered out before reaching the client.
    ! 3. Service-Layer Orchestration, functions as a thin wrapper around 'ProductServiceInterface'. This design follows the "Controller-Service-Repository" pattern, keeping the web-tier logic focused purely on HTTP status codes, path variables, and JSON payloads.
*/


@RestController
@RequestMapping(path = "/prodotti")
public class EcommerceProductsController {

	
		@Autowired
		ProductServiceInterface prodService;

		@ResponseStatus(HttpStatus.CREATED)
		@PostMapping(path="/aggiungiProd", consumes = "application/json")
		public void aggiungiProdotto(@RequestBody ManagementProductDTO prodotto) {
			prodService.aggiungiProdotto(prodotto);
		}
		
		
		@GetMapping(path = "/cercaProd/{idProdotto}")
		public ProductResponseDTO cercaProdottoID(@PathVariable int idProdotto) {
			return prodService.cercaProdottoID(idProdotto);
		}
		

		@GetMapping(path="/mostraProd")
		public List<ProductResponseDTO> mostaTuttiProdotti() {
			return prodService.mostaTuttiProdotti();
		}

		
	}


