package com.spring.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;


/* * Venditore - Marketplace Aggregate Root Entity
    ? The core persistent model for a marketplace seller. This entity not only stores biographical and credential data but also acts as the "One" side of a critical One-to-Many relationship, managing the lifecycle of all associated products through JPA orchestration.

    ! 1. Automated Identity Management, uses `@GeneratedValue(strategy = GenerationType.IDENTITY)` to delegate primary key creation to the database's auto-increment column. This ensures that each seller is assigned a unique, sequential ID without requiring manual ID management in the Java code.
    ! 2. Bidirectional Relationship Mapping, defines the `@OneToMany` association with the `Prodotto` entity. By using the `mappedBy = "venditore"` attribute, it informs Hibernate that the `Prodotto` entity owns the foreign key relationship, preventing the creation of an unnecessary join table.
    ! 3. Cascade Operations (All), implements `CascadeType.ALL` to ensure that any state change in the `Venditore` (like deletion or updates) is automatically propagated to their `listaProdotti`. This is essential for data integrity; if a seller is removed from the platform, their entire catalog is cleaned up simultaneously.
*/

@Entity
public class Venditore {
	
	//An autoincremental id, by any chance
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idVenditore;

	
	private String nome, cognome, username,password, via,città;
	
	
	@OneToMany(mappedBy = "venditore", cascade = CascadeType.ALL)
	private List<Prodotto> listaProdotti = new ArrayList<>();
	
	public Venditore() {}


	public Venditore(Integer idVenditore, String nome, String cognome, String username, String password, String via,
			String città, List<Prodotto> listaProdotti) {
		
		
		this.idVenditore = idVenditore;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public List<Prodotto> getListaProdotti() {
		return listaProdotti;
	}


	public void setListaProdotti(List<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}


	@Override
	public String toString() {
		return "Venditore [idVenditore=" + idVenditore + ", nome=" + nome + ", cognome=" + cognome + ", username="
				+ username + ", password=" + password + ", via=" + via + ", città=" + città + ", listaProdotti="
				+ listaProdotti + "]";
	}
	
	
	

	
	
	
	
	
	
	
	

}
