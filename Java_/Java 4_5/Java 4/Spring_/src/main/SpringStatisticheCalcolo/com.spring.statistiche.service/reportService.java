package com.spring.statistiche.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.statistiche.dao.StatisticheDAO;
import com.spring.statistiche.dto.ReportDTO;

/* * reportService - Statistics Retrieval Service
    ? Acts as the bridge between the reporting API and the persistence layer. It focuses on retrieving accumulated statistical data and formatting it for client consumption via Data Transfer Objects.

    ! 1. DTO Transformation, explicitly wraps raw data (whether a single Integer or the entire HashMap) into `ReportDTO` objects. This ensures that the controller receives a structured response object rather than raw collection types.
    ! 2. Read-Only Logic, distinct from the calculation service (which triggers updates via AOP), this component is dedicated strictly to *reading* the current state of the application's usage metrics.
*/

@Service
public class reportService {
	
	@Autowired
	public StatisticheDAO statisticheDAO;
	
	
	public ReportDTO caratteristicaOperazione(String tipoOperazione) {
		
		return new ReportDTO(tipoOperazione, statisticheDAO.selezionaOperazione(tipoOperazione));
		
	}
	
	
	public ReportDTO mostraReportTotale() {
		
		return new ReportDTO(statisticheDAO.mostraTutto());
	
	}

	
	
	
	
	
	
}