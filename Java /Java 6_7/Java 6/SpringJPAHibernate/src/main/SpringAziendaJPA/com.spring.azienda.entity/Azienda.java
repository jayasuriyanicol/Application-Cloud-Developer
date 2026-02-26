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

/* * Azienda - Core Persistent Entity
    ? The foundational blueprint of the database schema representing a corporate organization. This class utilizes Jakarta Persistence (JPA) to map Java objects directly to the relational database, serving as the "Owner" of the corporate structure and managing the financial and personnel state of the enterprise.

    ! 1. Automated Lifecycle Orchestration, uses the '@OneToMany' relationship with 'CascadeType.ALL' and 'orphanRemoval = true'. This ensures that the life of the employee records is strictly bound to the company; if a company is deleted, its entire roster is cleaned up automatically, maintaining referential integrity without manual SQL scripts.
    ! 2. Identity & Sequence Management, employs '@GeneratedValue' with 'IDENTITY' strategy to delegate primary key creation to the database's auto-increment feature. This prevents ID collisions in a multi-user environment and allows the application to focus on business data while the DB handles the low-level row identification.
    ! 3. Bidirectional Association Mapping, establishes the 'mappedBy' link to 'aziendaRiferimento' in the Employee entity. This creates a "mirror" effect where Spring Data JPA can efficiently navigate from a Company to its list of Employees, providing a high-performance path for building organizational charts and calculating total payroll.
*/

@Entity
public class Azienda {
	
	//Adding incremental value for the PK
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAzienda;
	
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
		return idAzienda;
	}


	public void setIdAzienda(Integer idAzienda) {
		this.idAzienda = idAzienda;
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
		return "Azienda [IdAzienda=" + idAzienda + ", intestazione=" + intestazione + ", capitaleSociale="
				+ capitaleSociale;
	}
	
	
	
	
	

	
	
}
