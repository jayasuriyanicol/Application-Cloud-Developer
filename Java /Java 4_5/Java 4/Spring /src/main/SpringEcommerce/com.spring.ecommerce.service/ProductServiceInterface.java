package com.spring.ecommerce.service;

import java.util.List;

import com.spring.ecommerce.dto.ManagementProductDTO;
import com.spring.ecommerce.dto.ProductResponseDTO;


/* * ProductServiceInterface - Catalog Service Contract
    ? A strategic interface that defines the high-level capabilities of the product management module. It acts as a formal agreement between the Controller and the Service layers, ensuring that all product-related operations follow a standardized protocol.

    ! 1. Administrative Gateway, establishes the `aggiungiProdotto` method as the primary entry point for catalog expansion. By requiring a `ManagementProductDTO`, it signals that this specific operation is tied to administrative credentials, which are intercepted and validated by the AOP security layer.
    ! 2. Information Hiding, enforces the use of `ProductResponseDTO` for all retrieval operations. This architectural choice ensures that the implementation layer can never accidentally leak raw Entity details or sensitive stock data to the caller, maintaining strict data privacy.
    ! 3. Implementation Flexibility, by utilizing an interface, the system supports easy scaling. Whether the actual business logic uses an In-Memory cache, a relational database, or calls an external microservice, the Controllers remain unchanged because they depend only on this stable abstraction.
*/


public interface ProductServiceInterface {
	

		public void aggiungiProdotto(ManagementProductDTO prodManageDTO);

		public ProductResponseDTO cercaProdottoID(int idProdotto);

		public List<ProductResponseDTO> mostaTuttiProdotti();
	}


