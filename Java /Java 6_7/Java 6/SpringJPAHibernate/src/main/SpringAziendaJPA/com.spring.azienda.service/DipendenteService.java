package com.spring.azienda.service;

import java.util.List;


import com.spring.azienda.dto.DipendenteDTO;
import com.spring.azienda.entity.PostoAuto;

public interface DipendenteService  {
	
	//Service AziendaImpiegato
	public void inserisciDipendenteSenzaPostoAuto(Integer IdAzienda,DipendenteDTO dipendente);
	public void inserisciDipendenteConPostoAuto(Integer IdAzienda,DipendenteDTO dipendente, PostoAuto postoAuto);
	public void inserisciDipendenteAssegnaPostoAuto(Integer IdAzienda,Integer IdPostoAuto,DipendenteDTO dipendente);
	
	
	public List<DipendenteDTO> visualizzaDipendenti();
	public List<DipendenteDTO> visualizzaNomiCognDipendenti();
	public List<DipendenteDTO> visualizzaDipeDatoSalario(Double salario);
	public DipendenteDTO cancellaImpiegato(String IdMatricola);
	public DipendenteDTO cancellaImpiegatoMatricola(String IdMatricola);
	
	//Method EXTRA
	public DipendenteDTO spostaImpiegatoAzienda(String IdMatricola, Integer IdAzienda);
	
	
	//Service Impiegato 
	public DipendenteDTO modificaSalarioDipendente(String IdMatricola, Double salarioNuovo);
	public DipendenteDTO modificaPostoAuto(String IdMatricola, Integer postoAutoNuovo);
	public DipendenteDTO visualizzaSeEsistePostoAuto(String IdMatricola);
	

}
