package com.spring.rubrica.entity;

import java.util.HashSet;

/* * rubrica - Phonebook Aggregate Entity
    ? Represents the primary domain entity acting as a container for a collection of contacts. It serves as the root object for organizing contact details under a specific owner and timeframe.

    ! 1. Collection Semantics, utilizes a `HashSet` for storage, which inherently prevents duplicate contacts (based on name/surname logic defined in the child entity) and ensures efficient lookups.
    ! 2. Domain Hierarchy, establishes a clear One-to-Many relationship. The `rubrica` owns the lifecycle of its `contattoTelefonico` entries, effectively grouping them under a specific `proprietario`.
*/



public class rubrica {
	
	private int idContatto;
	private String proprietario, annoCreazione;
	private HashSet<contattoTelefonico> contatto = new HashSet<>();

	public rubrica(String proprietario, String annoCreazione) {
		
	
		this.proprietario = proprietario;
		this.annoCreazione = annoCreazione;
	}

	
	
	public void setId(int id) {
		
		this.idContatto = id;
	}
	
	public int getId() {
		
		return idContatto;
	}
	
	
	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getAnnoCreazione() {
		return annoCreazione;
	}

	public void setAnnoCreazione(String annoCreazione) {
		this.annoCreazione = annoCreazione;
	}
	
	
	public HashSet<contattoTelefonico> getContatti() {
		return contatto;
	
	}
	
	public void setContatti(HashSet<contattoTelefonico> contatto) {
		this.contatto = contatto;
	}
	
	
	
	
		

}
