package com.spring.cc.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.spring.cc.dataTypes.RealGEZ;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Movimento {

	@Id
	@GeneratedValue( strategy =  GenerationType.IDENTITY)
	private Integer idMovimento;
	
	public enum tipoMovimento {
		
		versamento,
		prelievo
	}
	
	@Enumerated(EnumType.STRING)
	private tipoMovimento operazione;
	
	@Embedded
	@AttributeOverride(name = "value", column = @Column (name = "importo"))
	private RealGEZ importo;

	@Column(name = "data_movimento", nullable = false)
	private LocalDateTime dataOperazione;
	
	
	//Creation of the values linked to the CC account, data of Operatore and ContoAssociato and Suppress because no GETTER
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_conto", nullable = false)
	@JoinColumn(name = "id_operatore", nullable = false)
	private Utente operatoreBanca;
	

	// ? Using the '@JsonIgnore' to avoid infinite recursion on TEST in PostMan.
	@ManyToOne(optional = false)
	@JsonIgnore
	private ContoCorrente contoAssociato;
	
	
	
	public Movimento() {}
	public Movimento(Integer idMovimento, tipoMovimento operazione, RealGEZ importo, LocalDateTime dataOperazione) {
	
		this.idMovimento = idMovimento;
		this.operazione = operazione;
		this.importo = importo;
		this.dataOperazione = dataOperazione;
	}



	public Integer getIdMovimento() {
		return idMovimento;
	}



	public void setIdMovimento(Integer idMovimento) {
		this.idMovimento = idMovimento;
	}



	public tipoMovimento getOperazione() {
		return operazione;
	}



	public void setOperazione(tipoMovimento operazione) {
		this.operazione = operazione;
	}



	public RealGEZ getImporto() {
		return importo;
	}



	public void setImporto(RealGEZ importo) {
		this.importo = importo;
	}



	public LocalDateTime getDataOperazione() {
		return dataOperazione;
	}



	public void setDataOperazione(LocalDateTime dataOperazione) {
		this.dataOperazione = dataOperazione;
	}
	
	
	//SETTER & GETTER of the values linked to the CC account, data of Operatore and ContoAssociato

	public void setOperatoreBanca(Utente operatoreBanca) {
		this.operatoreBanca = operatoreBanca;
	}

	public Utente getOperatoreBanca() {
		return operatoreBanca;
	}
	
	public void setContoAssociato(ContoCorrente contoAssociato) {
		this.contoAssociato = contoAssociato;
	}
	
	public ContoCorrente getContoAssociato() {
		return contoAssociato;
	}




	
	
	
	
	
	
	
	

}
