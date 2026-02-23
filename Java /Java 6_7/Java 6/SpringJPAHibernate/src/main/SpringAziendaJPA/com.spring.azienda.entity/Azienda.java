package com.spring.azienda.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;


@Entity
public class Azienda {
	
	//Adding incremental value for the PK
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdAzienda;
	
	private String intestazione;
	private Double capitaleSociale;
	
	//Reference to the FK aziendaRiferimento in Dipendente and adding the cascade type to avoid any problem by any changes
	@OneToMany(mappedBy = "aziendaRiferimento", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Dipendente> listaDipendenti= new HashSet<>();

	
	
	public Azienda() {}
	
	
	public Azienda(Integer idAzienda, String intestazione, Double capitaleSociale, Set<Dipendente> listaDipendenti) {
		
		
		this.intestazione = intestazione;
		this.capitaleSociale = capitaleSociale;
		this.listaDipendenti = listaDipendenti;
		
		
	}


	public Integer getIdAzienda() {
		return IdAzienda;
	}


	public void setIdAzienda(Integer idAzienda) {
		IdAzienda = idAzienda;
	}


	public String getIntestazione() {
		return intestazione;
	}


	public void setIntestazione(String intestazione) {
		this.intestazione = intestazione;
	}


	public Double getCapitaleSociale() {
		return capitaleSociale;
	}


	public void setCapitaleSociale(Double capitaleSociale) {
		this.capitaleSociale = capitaleSociale;
	}


	public Set<Dipendente> getListaDipendenti() {
		return listaDipendenti;
	}


	public void setListaDipendenti(Set<Dipendente> listaDipendenti) {
		this.listaDipendenti = listaDipendenti;
	}
	
	

	
	//Doing the Hash and Equals to prevent any inconguence in the list of Dipendenti
	@Override
	public int hashCode() {
		return Objects.hash(listaDipendenti);
	}


	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		
		Azienda other = (Azienda) obj;
		return Objects.equals(listaDipendenti, other.listaDipendenti);
	}


	@Override
	public String toString() {
		return "Azienda [IdAzienda=" + IdAzienda + ", intestazione=" + intestazione + ", capitaleSociale="
				+ capitaleSociale;
	}
	
	
	
	
	

	
	
}
