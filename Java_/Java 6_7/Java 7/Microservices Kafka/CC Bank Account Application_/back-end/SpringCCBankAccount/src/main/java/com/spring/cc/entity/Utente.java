package com.spring.cc.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Utente {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUtente;
	
	@Column(nullable = false)
	private String nome;
	

	@Column(nullable = false)
	private String cognome;
	
	//Not orphan value, associated to 'Indirizzo'
	@OneToOne(cascade = CascadeType.ALL, optional= false)
	@JoinColumn(name= "id_indirizzo")
	private Indirizzo indirizzo;
	
	@Column(nullable = false, unique= true)
	private String mail; 
	
	//Attribute not need it
	private String telefono;
	

	// ? Using the '@JsonIgnore' to avoid infinite recursion on TEST in PostMan.
	@OneToMany(mappedBy="intestatario")
	@JsonIgnore
	private List<ContoCorrente> listaContiIntestati;
	
	@OneToMany(mappedBy="cointestatario")
	@JsonIgnore
	private List<ContoCorrente> listaContiCointestati;
	
	public Utente () {}
	
	public Utente(Integer idUtente, String nome, String cognome, String mail, String telefono, Indirizzo indirizzo) {
		
		this.idUtente = idUtente;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.cognome = cognome;
		this.mail = mail;
		this.telefono = telefono;
	}


	public Integer getIdUtente() {
		return idUtente;
	}


	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
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


	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	
	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public List<ContoCorrente> getListaContiIntestati() {
		return listaContiIntestati;
	}

	public void setListaContiIntestati(List<ContoCorrente> listaContiIntestati) {
		this.listaContiIntestati = listaContiIntestati;
	}

	public List<ContoCorrente> getListaContiCointestati() {
		return listaContiCointestati;
	}

	public void setListaContiCointestati(List<ContoCorrente> listaContiCointestati) {
		this.listaContiCointestati = listaContiCointestati;
	}
	
	
	
	
	
	
}	

	
	
	
	
	
	
	

