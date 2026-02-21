package com.spring.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;


/* * VenditoreDTO - Marketplace Vendor Data Structure
    ? A complex Data Transfer Object representing a seller within the e-commerce ecosystem. It serves as a specialized view that aggregates personal information, location details, and the associated inventory of products.

    ! 1. Security-First Data Shaping, deliberately omits the 'password' field found in the database entity. This ensures that vendor credentials are never transmitted over the network during standard profile lookups, effectively mitigating the risk of sensitive data exposure in JSON responses.
    ! 2. Nested Collection Mapping, maintains a 'List<ProdottoDTO>' to represent the One-to-Many relationship between a seller and their goods. This allows the API to return a comprehensive vendor profile, including their entire catalog, in a single, efficient HTTP response.
    ! 3. Aggregate Root Representation, acts as the primary container for vendor-specific metadata such as username and physical address. By bundling these fields with the product list, it provides the frontend with all the necessary context to render a complete "Storefront" view for the end-user.
*/


public class VenditoreDTO {

	

	//Here the PRIMARY KEY
	private Integer idVenditore;

	
	
	//Deleting the PASSWORD for problems security
	private String nome, cognome, username, via,città;
	
	
	//Here the Link with te Product, a list of Products
	private List<ProdottoDTO> listaProdotti = new ArrayList<>();
	
	public VenditoreDTO() {}


	public VenditoreDTO(Integer idVenditore, String nome, String cognome, String username, String via,
			String città, List<ProdottoDTO> listaProdotti) {
		
		
		this.idVenditore = idVenditore;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.via = via;
		this.città = città;
		this.listaProdotti = listaProdotti;
	}


	public Integer getIdVenditore() {
		return idVenditore;
	}


	public void setIdVenditore(Integer idVenditore) {
		this.idVenditore = idVenditore;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getVia() {
		return via;
	}


	public void setVia(String via) {
		this.via = via;
	}


	public String getCittà() {
		return città;
	}


	public void setCittà(String città) {
		this.città = città;
	}


	public List<ProdottoDTO> getListaProdotti() {
		return listaProdotti;
	}


	public void setListaProdotti(List<ProdottoDTO> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}


	
}
