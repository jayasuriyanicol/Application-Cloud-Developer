package com.spring.ecommerce.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ecommerce.dao.ProductInterfaceDAO;
import com.spring.ecommerce.dto.ManagementProductDTO;
import com.spring.ecommerce.dto.ProductResponseDTO;
import com.spring.ecommerce.entity.Product;

/* * ProductService - Business Logic & Data Transformation
    ? The core engine for product management. It acts as the intermediary between the API controllers and the persistence layer, orchestrating the conversion of raw data into meaningful business objects and vice versa.

    ! 1. Bidirectional Mapping, provides static utility methods (`ProductDTOtoEntity` and `EntityProductToDTO`) to bridge the gap between internal entities and external DTOs. This manual mapping ensures that the API contract remains decoupled from the database structure, allowing for independent evolution of the two.
    ! 2. Functional Stream Processing, leverages the Java Stream API in the `mostaTuttiProdotti` method. This allows for clean, declarative transformation of entire product lists, efficiently mapping each database record to a secure, client-ready response format in a single pipeline.
    ! 3. Protected Execution, while this service contains standard CRUD logic, it is the primary target of the `InterceptorAccess` aspect. Because it accepts `ManagementProductDTO` in the `aggiungiProdotto` method, it triggers the automated security handshake before any data is passed to the DAO.
*/


@Service
public class ProductService implements ProductServiceInterface {
	
	@Autowired
	ProductInterfaceDAO productInterfDAO;

	public static Product ProductDTOtoEntity(ManagementProductDTO prodManageDTO) {
		
	    if (prodManageDTO == null)
	        return null;

		Product productEntity = new Product();
		productEntity.setId(prodManageDTO.getId());
		productEntity.setName(prodManageDTO.getName());
		productEntity.setPrice(prodManageDTO.getUnitPrice());
		productEntity.setStock(prodManageDTO.getStock());

		return productEntity;
	}

	public static ProductResponseDTO EntityProductToDTO (Product productEntity) {
		
		if (productEntity == null)
			return null;

		ProductResponseDTO productRespDTO = new ProductResponseDTO();
		productRespDTO.setId(productEntity.getId());
		productRespDTO.setName(productEntity.getName());
		productRespDTO.setUnitPrice(productEntity.getPrice());
		productRespDTO.setStock(productEntity.getStock());

		return productRespDTO;
	}

	@Override
	public void aggiungiProdotto(ManagementProductDTO prodManageDTO ) {
		
		productInterfDAO.inserisciProdotto(ProductDTOtoEntity(prodManageDTO));
	}

	@Override
	public ProductResponseDTO cercaProdottoID(int idProdotto) {
		return EntityProductToDTO(productInterfDAO.selezionaID(idProdotto));
	}

	@Override
	public List<ProductResponseDTO> mostaTuttiProdotti() {
		
		return productInterfDAO.mostraTutto()
				.stream()
				.map(prodotto -> EntityProductToDTO(prodotto))
				.toList();
	}
}