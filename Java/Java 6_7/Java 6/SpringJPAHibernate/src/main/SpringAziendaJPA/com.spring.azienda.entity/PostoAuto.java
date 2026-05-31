package com.spring.azienda.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/* * PostoAuto - Specialized Resource Entity
    ? A persistent model representing a physical corporate asset: a parking space. This entity completes the circular reference within the "Azienda" ecosystem, allowing the database to track the allocation of limited physical resources to specific employees through a tightly coupled One-to-One relationship.

    ! 1. Bidirectional Association Ownership, utilizes the 'mappedBy = "postoAuto"' attribute to designate this class as the "inverse" side of the relationship. This tells JPA that the actual foreign key column (FK_PostoAuto) is physically located in the 'Dipendente' table, while still allowing the application to navigate from a parking spot back to its owner.
    ! 2. Life-Cycle Synchronization, implements 'CascadeType.ALL' to ensure that state changes are propagated across the relationship. This is particularly useful for administrative tasks; if a parking resource is updated or managed independently, the associated employee link remains synchronized in the persistence context.
    ! 3. Physical Asset Descriptors, includes the 'posizione' field to provide human-readable context (e.g., "Lot A-42") alongside the numeric 'idPostoAuto'. This separation allows the business logic to manage parking assignments based on physical location while the database maintains strict relational integrity via the primary key.
*/

@Entity
public class PostoAuto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPostoAuto;
	
	
	@OneToOne(mappedBy= "postoAuto", cascade = CascadeType.ALL)
	private Dipendente dipendenteAzienda;
	
	private String posizione;
	
	public PostoAuto() {}

	public PostoAuto(Integer idPostoAuto, Dipendente dipendenteAzienda, String posizione) {
		
		
		this.dipendenteAzienda = dipendenteAzienda;
		this.posizione = posizione;
	}

	public Integer getIdPostoAuto() {
		return idPostoAuto;
	}

	public void setIdPostoAuto(Integer idPostoAuto) {
		this.idPostoAuto = idPostoAuto;
	}

	public Dipendente getDipendenteAzienda() {
		return dipendenteAzienda;
	}

	public void setDipendenteAzienda(Dipendente dipendenteAzienda) {
		this.dipendenteAzienda = dipendenteAzienda;
	}

	public String getPosizione() {
		return posizione;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}

	@Override
	public String toString() {
		return "PostoAuto [IdPostoAuto=" + idPostoAuto + ", dipendenteAzienda=" + dipendenteAzienda + ", posizione="
				+ posizione + "]";
	}
	
	
	
	
	
	
	
	
}