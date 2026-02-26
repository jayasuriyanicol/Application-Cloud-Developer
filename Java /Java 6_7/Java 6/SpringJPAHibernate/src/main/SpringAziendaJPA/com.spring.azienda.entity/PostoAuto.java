package com.spring.azienda.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

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