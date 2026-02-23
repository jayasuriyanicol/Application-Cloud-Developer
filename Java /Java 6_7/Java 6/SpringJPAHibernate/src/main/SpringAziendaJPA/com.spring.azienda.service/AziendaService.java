package com.spring.azienda.service;

import java.util.List;

import com.spring.azienda.dto.AziendaDTO;
import com.spring.azienda.dto.AziendaInfoDTO;

public interface AziendaService {
	
	//Service Azienda
	public void inserisciNuovaAzienda(AziendaDTO azienda);
	public AziendaDTO visualizzaDatiAzienda(Integer IdAzienda);
	public AziendaDTO visualizzaDatiBase(Integer IdAzienda);
	public List<AziendaDTO> visualizzaTutteAziende();
	public AziendaInfoDTO visualizzaNomeNumDip(Integer IdAzienda);
	public AziendaInfoDTO visualizzaMaggioreCapitaleAzienda();
	public AziendaDTO modificaCapitaleAzienda(Integer IdAzienda,Double capitaleNuovo);
	public AziendaDTO modificaIntestazioneAzienda(Integer IdAzienda, String nuovaIntestazione);
	public AziendaDTO cancellaAziendaNoDipendenti(Integer IdAzienda);


}
