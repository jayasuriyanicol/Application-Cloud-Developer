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
	private Integer IdPostoAuto;
	
	
	@OneToOne(mappedBy= "postoAuto", cascade = CascadeType.ALL)
	private Dipendente dipendenteAzienda;
	
	private String posizione;
	
	public PostoAuto() {}

	public PostoAuto(Integer idPostoAuto, Dipendente dipendenteAzienda, String posizione) {
		
		
		this.dipendenteAzienda = dipendenteAzienda;
		this.posizione = posizione;
	}

	public Integer getIdPostoAuto() {
		return IdPostoAuto;
	}

	public void setIdPostoAuto(Integer idPostoAuto) {
		IdPostoAuto = idPostoAuto;
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
		return "PostoAuto [IdPostoAuto=" + IdPostoAuto + ", dipendenteAzienda=" + dipendenteAzienda + ", posizione="
				+ posizione + "]";
	}
	
	
	
	
	
	
	
	
}