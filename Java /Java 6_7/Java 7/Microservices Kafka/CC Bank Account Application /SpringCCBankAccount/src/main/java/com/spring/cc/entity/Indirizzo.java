package com.spring.cc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Indirizzo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idIndirizzo;
	
	@Column(nullable = false)
	private String via;
	
	//Because there are some cases CAP with char + Numbers
	@Column(nullable = false)
	private String cap; 
	
	@Column(nullable = false)
	private String citta;
	
	@Column(nullable = false)
	private String provincia;
	
	
	public Indirizzo() {}
	
	public Indirizzo(Integer idIndirizzo, String via, String cap, String citta, String provincia) {

		this.idIndirizzo = idIndirizzo;
		this.via = via;
		this.cap = cap;
		this.citta = citta;
		this.provincia = provincia;
	}


	public Integer getIdIndirizzo() {
	
		
		return idIndirizzo;
	}
	
	
	public void setIdIndirizzo(Integer idIndirizzo) {
		this.idIndirizzo = idIndirizzo;
	}
	
	public String getVia() {
		return via;
	}
	
	public void setVia(String via) {
		this.via = via;
	}
	
	public String getCap() {
		return cap;
	}
	
	public void setCap(String cap) {
		this.cap = cap;
	}
	
	public String getCitta() {
		return citta;
	}
	
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	public String getProvincia() {
		return provincia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	
	
	
	
	

}
