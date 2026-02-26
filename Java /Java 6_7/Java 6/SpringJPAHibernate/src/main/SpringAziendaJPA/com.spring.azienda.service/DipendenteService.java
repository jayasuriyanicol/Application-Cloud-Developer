package com.spring.azienda.service;

import java.util.List;


import com.spring.azienda.dto.DipendenteDTO;
import com.spring.azienda.entity.PostoAuto;

/* * DipendenteService - Workforce Management Contract
    ? The functional blueprint for personnel operations within the "Azienda" ecosystem. This interface defines the high-level business rules for employee lifecycle management, resource allocation (parking), and inter-company mobility, abstracting the multi-repository orchestration required to manage human resources.

    ! 1. Polymorphic Onboarding Logic, declares three distinct strategies for hiring: basic insertion, insertion with a new physical asset, and assignment to an existing resource. This allows the implementation to handle various corporate onboarding scenarios—from standard hires to executive assignments—through a unified service layer.
    ! 2. Organizational Mobility Engine, introduces the 'spostaImpiegatoAzienda' contract. This critical business method signals a complex operation that must handle the reassignment of an employee's foreign key from one 'Azienda' to another, ensuring that company-specific rosters remain synchronized during internal transfers.
    ! 3. Resource Asset Coupling, specifies methods for managing the 'PostoAuto' relationship ('modificaPostoAuto', 'visualizzaSeEsistePostoAuto'). These definitions ensure that employee records are inextricably linked to their physical corporate benefits, allowing the system to query and update facility assignments based solely on the employee's unique 'matricola'.
*/


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
