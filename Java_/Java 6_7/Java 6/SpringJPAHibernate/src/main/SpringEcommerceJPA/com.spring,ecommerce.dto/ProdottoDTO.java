package com.spring.ecommerce.dto;

/* * ProdottoDTO - Inventory Item Data Transfer Object
    ? A detailed representation of a marketplace item, designed to carry both commercial data and relational metadata. It facilitates the movement of product information from the database to the client-side UI, maintaining a clean separation between the internal entity and the external JSON output.

    ! 1. Relational Flattening, includes the 'venditore' field as a simple Integer ID (Foreign Key reference) instead of a full Seller object. This "flattening" technique prevents circular dependency issues during JSON serialization while still allowing the client to know exactly which vendor owns the product.
    ! 2. Commercial Attribute Modeling, captures essential e-commerce metrics like 'prezzoUnitario', 'quantità', and 'sconto'. By grouping these fields, the DTO provides all the necessary data for the frontend to calculate final prices, display stock levels, and apply promotional discounts in real-time.
    ! 3. Categorization & Searchability, utilizes the 'categoria' string to enable easy filtering on the client side. This allows the API to serve structured data that can be immediately used for grouping products in store-front views or search result pages without additional server-side processing.
*/



public class ProdottoDTO {
	
	

	//Here the PRIMARY KEY
	private Integer idProdotto;
	
	//Here the FOREIGN KEY
	private Integer venditore;
	
	
	private String descrizione;
	private Integer quantità,sconto;
	private Double prezzoUnitario;
	private String categoria;
	
	public ProdottoDTO() {}
	
	
	public ProdottoDTO(Integer idProdotto, String descrizione, Integer quantità, Integer sconto, Integer venditore,Double prezzoUnitario, String categoria) {
		
		this.idProdotto = idProdotto;
		this.descrizione = descrizione;
		this.quantità = quantità;
		this.sconto = sconto;
		this.prezzoUnitario = prezzoUnitario;
		this.categoria = categoria;
		this.venditore = venditore;
	}


	public Integer getIdProdotto() {
		return idProdotto;
	}


	public void setIdProdotto(Integer idProdotto) {
		this.idProdotto = idProdotto;
	}


	public Integer getVenditore() {
		return venditore;
	}


	public void setVenditore(Integer venditore) {
		this.venditore = venditore;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public Integer getQuantità() {
		return quantità;
	}


	public void setQuantità(Integer quantità) {
		this.quantità = quantità;
	}


	public Integer getSconto() {
		return sconto;
	}


	public void setSconto(Integer sconto) {
		this.sconto = sconto;
	}


	public Double getPrezzoUnitario() {
		return prezzoUnitario;
	}


	public void setPrezzoUnitario(Double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	
	}

