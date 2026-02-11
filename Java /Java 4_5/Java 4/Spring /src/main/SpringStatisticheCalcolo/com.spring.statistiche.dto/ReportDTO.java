package com.spring.statistiche.dto;
import java.util.HashMap;

/* * ReportDTO - Data Transfer Object
    ? A wrapper object designed to transport statistical data (operation frequencies) from the Service layer to the REST Controller, ensuring a structured JSON response.

    ! 1. Constructor Overloading, offers versatile instantiation logic: one constructor allows creating a report for a single specific operation, while another accepts a complete dataset for global reporting.
    ! 2. Encapsulation, wraps the raw `HashMap` within a DTO to define a clear API contract. This prevents exposing the internal collection structure directly and allows for future expansion (e.g., adding a timestamp) without breaking the client contract.
*/



public class ReportDTO {
	
	private HashMap<String, Integer> reportOperazioni = new HashMap<>();
	
	public ReportDTO() {
		
	}
	
	public ReportDTO(String tipoOperazione, int numeroOccorrenze) {
		
		reportOperazioni.put(tipoOperazione, numeroOccorrenze);		
}
	
	public ReportDTO(HashMap<String,Integer> reportOperazioni) {
		
		this.reportOperazioni = reportOperazioni;
	
	}
	
	
	
	public HashMap<String, Integer> getReportOperazioni() {
		
		return reportOperazioni;
	}
	
	
	public void inizializzaReportOperazioni(HashMap<String,Integer> reportOperazioni) {
			
			this.reportOperazioni = reportOperazioni;
		
		}
	
	


	
	
	
	
	
}
