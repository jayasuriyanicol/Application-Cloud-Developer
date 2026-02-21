package com.spring.ecommerce.service;

import com.spring.ecommerce.dto.ProdottoDTO;
import com.spring.ecommerce.dto.VenditoreDTO;


/* * EcommerceService - Marketplace Business Contract
    ? The core architectural blueprint defining the operations available for the e-commerce ecosystem. This interface acts as a formal "Service Level Agreement" (SLA) between the API controllers and the underlying persistence logic, ensuring consistent behavior for vendor and inventory management.

    ! 1. Administrative Security Abstraction, defines critical credential management operations like 'inserisciVenditore' and 'modificaPassVend'. By separating the password from the DTO in the method signatures, it enforces a security protocol where sensitive strings are handled distinctly from general profile data.
    ! 2. Inventory Association Logic, establishes the 'aggiungiProdottoVend' contract, which requires a Vendor ID to create a Product. This ensures that no product can exist in the system without a clear owner, maintaining the relational integrity required for a multi-tenant marketplace.
    ! 3. Granular Data Access, provides multiple ways to view vendor information—offering both a full profile ('visualizzaVendID') and a restricted data view ('visualizzaDatiVend'). This flexibility allows the frontend to optimize performance by requesting only the biographical data when the full product catalog isn't necessary.
*/


public interface EcommerceService {
	
	public void inserisciVenditore(VenditoreDTO venditore,String password);
	public VenditoreDTO visualizzaVendID(Integer idVenditore);
	public VenditoreDTO visualizzaDatiVend(Integer idVenditore);
	public VenditoreDTO modificaPassVend(Integer idVenditore, String nuovaPassword);
	public void aggiungiProdottoVend(Integer idVenditore, ProdottoDTO prodottoDTO);
	public ProdottoDTO modificaQuantitàProd(Integer idProdotto, Integer nuovaQuantità);
	
	
	
	
	

}
