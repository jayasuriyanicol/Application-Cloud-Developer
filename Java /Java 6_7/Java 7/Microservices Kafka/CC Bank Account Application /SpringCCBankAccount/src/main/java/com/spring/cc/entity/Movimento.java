package com.spring.cc.entity;

import java.time.LocalDateTime;

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
	private LocalDateTime dataOperazione;
	
	
	//Creation of the values linked to the CC account, data of Operatore and ContoAssociato and Suppress because no GETTER
	
	@SuppressWarnings("unused")
	@ManyToOne(optional = false)
	private Utente operatoreBanca;
	
	@ManyToOne(optional = false)
	@SuppressWarnings("unused")
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
	
	
	//SETTER of the values linked to the CC account, data of Operatore and ContoAssociato
	
	public void setOperatoreBanca(Utente operatoreBanca) {
		this.operatoreBanca = operatoreBanca;
	}



	public void setContoAssociato(ContoCorrente contoAssociato) {
		this.contoAssociato = contoAssociato;
	}


	
	
	
	
	
	
	
	

}
