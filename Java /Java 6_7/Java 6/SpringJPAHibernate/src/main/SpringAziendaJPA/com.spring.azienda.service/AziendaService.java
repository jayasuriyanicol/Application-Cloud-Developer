package com.spring.azienda.service;

import java.util.List;

import com.spring.azienda.dto.AziendaDTO;
import com.spring.azienda.dto.AziendaInfoDTO;

/* * AziendaService - Business Logic Contract
    ? The defining interface for the "Azienda" (Company) functional layer. It acts as a formal contract that specifies exactly what operations can be performed on corporate data, abstracting the complex orchestration of repositories and mappers away from the Controller.

    ! 1. Administrative Life-Cycle Operations, declares the standard methods for corporate management, including registration ('inserisciNuovaAzienda') and various update strategies. By defining these here, the service layer ensures that business rules—such as how capital is modified—are consistent across the entire application.
    ! 2. Diverse Data Projection Needs, specifies different "View" methods like 'visualizzaDatiBase' versus 'visualizzaDatiAzienda'. This allows the implementation to optimize database performance by fetching only the required fields or associated collections (like employees) based on the specific use case.
    ! 3. Advanced Analytical Hooks, includes high-level query signatures such as 'visualizzaMaggioreCapitaleAzienda' and 'visualizzaNomeNumDip'. These methods signal the need for complex logic, such as finding the top-performing company or calculating employee counts, which will be implemented using JPA custom queries or stream processing in the implementation class.
*/

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
