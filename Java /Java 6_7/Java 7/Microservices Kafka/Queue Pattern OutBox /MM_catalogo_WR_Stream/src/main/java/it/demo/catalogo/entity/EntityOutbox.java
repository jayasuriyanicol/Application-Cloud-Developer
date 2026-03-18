package it.demo.catalogo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class EntityOutbox {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEvento;
	
	public enum TipoEvento {
		
		INSERIMENTO,
		CANCELLAZIONE, 
		MODIFICA
	};

    public enum TipoStato{

        SEND,
        FAIL,
        PENDING

    
   }


	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;

	@Enumerated(EnumType.STRING) 
    private TipoStato stato;

	private LocalDateTime dataCreazione;
	private LocalDateTime dataUltimaModifica;
	
	private Integer numeroTentativi;
	
	private String Payload;
	
	private Integer idProdotto;
	
	@Version
	private Integer versione;
	
	
	public EntityOutbox() {}


	public EntityOutbox(Integer idEvento, TipoEvento tipoEvento, LocalDateTime dataCreazione, LocalDateTime dataUltimaModifica,
			Integer numeroTentativi, TipoStato stato, String payload, Integer idProdotto, Integer versione) {
		
		this.idEvento = idEvento;
		this.tipoEvento = tipoEvento;
		this.dataCreazione = dataCreazione;
		this.dataUltimaModifica = dataUltimaModifica;
		this.numeroTentativi = numeroTentativi;
		this.stato = stato;
		this.Payload = payload;
		this.idProdotto = idProdotto;
		this.versione = versione;
	}


	public Integer getIdEvento() {
		return idEvento;
	}


	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	
	public TipoEvento getTipoEvento() {
		
		return tipoEvento;
	}
	
	
	public void setTipoEvento(TipoEvento tipoEvento) {
		
		this.tipoEvento = tipoEvento;
	}


	public LocalDateTime getDataCreazione() {
		return dataCreazione;
	}


	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione = dataCreazione;
	}


	public LocalDateTime getDataUltimaModifica() {
		return dataUltimaModifica;
	}


	public void setDataUltimaModifica(LocalDateTime dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}


	public Integer getNumeroTentativi() {
		return numeroTentativi;
	}


	public void setNumeroTentativi(Integer numeroTentativi) {
		this.numeroTentativi = numeroTentativi;
	}


	public TipoStato getStato() {
		return stato;
	}


	public void setStato(TipoStato stato) {
		this.stato = stato;
	}


	public String getPayload() {
		return Payload;
	}


	public void setPayload(String payload) {
		Payload = payload;
	}


	public Integer getIdProdotto() {
		return idProdotto;
	}


	public void setIdProdotto(Integer idProdotto) {
		this.idProdotto = idProdotto;
	}


	public Integer getVersione() {
		return versione;
	}


	public void setVersione(Integer versione) {
		this.versione = versione;
	}
	

}
