package it.demo.catalogo.dto;

import java.time.LocalDateTime;

public class EntityOutboxDTO {
	
	
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


	
	private TipoEvento tipoEvento;
	
   
    private TipoStato stato;

	private LocalDateTime dataCreazione;
	private LocalDateTime dataUltimaModifica;
	
	private Integer numeroTentativi;
	
	private String Payload;
	
	private Integer idProdotto;
	
	
	private Integer versione;
	
	
	public EntityOutboxDTO() {}


	public EntityOutboxDTO(Integer idEvento, TipoEvento tipoEvento, LocalDateTime dataCreazione, LocalDateTime dataUltimaModifica,
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
