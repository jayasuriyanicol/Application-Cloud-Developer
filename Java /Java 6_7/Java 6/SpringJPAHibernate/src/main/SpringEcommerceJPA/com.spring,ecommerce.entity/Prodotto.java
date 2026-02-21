package com.spring.ecommerce.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/* * Prodotto - Marketplace Inventory Entity
    ? The persistent domain model for a single product. It represents the "Many" side of the relationship with the Vendor, holding the critical foreign key that links the inventory item to its owner in the relational database.

    ! 1. Relational Ownership, uses the `@ManyToOne` annotation to establish the many-to-one link. The `@JoinColumn(name = "FK_Venditore")` explicitly names the foreign key column in the database table, providing clear traceability between products and their specific sellers.
    ! 2. Automated Key Generation, mirrors the Vendor entity by using `GenerationType.IDENTITY`. This ensures the database handles the unique indexing of the `idProdotto`, allowing for seamless, conflict-free scaling as the marketplace catalog grows.
    ! 3. Commercial State Persistence, stores all metadata required for e-commerce logic—such as unit price, category, and quantity. Because this entity is managed by the persistence context, any change to these fields within a transaction will be automatically synchronized with the DB.
*/


@Entity
public class Prodotto {
	
	//An autoincremental id, by any chance
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProdotto;
	
	//Rapresenting the N .. 1 in the UML diagrammm
	@ManyToOne
	@JoinColumn(name = "FK_Venditore")
	private Venditore venditore;
	
	
	private String descrizione;
	private Integer quantità,sconto;
	private Double prezzoUnitario;
	private String categoria;
	
	public Prodotto() {}
	
	
	public Prodotto(Integer idProdotto, String descrizione, Integer quantità, Integer sconto, Venditore venditore,Double prezzoUnitario, String categoria) {
		
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


	public Venditore getVenditore() {
		return venditore;
	}


	public void setVenditore(Venditore venditore) {
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


	@Override
	public String toString() {
		return "Prodotto [idProdotto=" + idProdotto + ", venditore=" + venditore + ", descrizione=" + descrizione
				+ ", quantità=" + quantità + ", sconto=" + sconto + ", prezzoUnitario=" + prezzoUnitario
				+ ", categoria=" + categoria + "]";
	}


	
	
	
	
	

}