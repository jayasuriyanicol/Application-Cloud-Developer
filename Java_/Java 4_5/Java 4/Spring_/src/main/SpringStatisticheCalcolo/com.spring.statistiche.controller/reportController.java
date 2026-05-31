package com.spring.statistiche.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.statistiche.dto.ReportDTO;
import com.spring.statistiche.service.reportService;



/* * reportController - Reporting API Endpoint
    ? Serves as the RESTful interface for the application's statistical layer, allowing clients to request operation-specific metrics or full system reports via HTTP.

    ! 1. Endpoint Organization, uses `@RequestMapping("/report")` to group all statistic-related resources under a dedicated namespace, keeping the API structure clean and separated from the calculation logic.
    ! 2. Dynamic Resource Access, the `registraOperazione` method utilizes `@PathVariable` to capture the operation type (e.g., "sum", "div") directly from the URL, enabling flexible querying of specific operation stats.
    ! 3. DTO Serialization, returns `ReportDTO` objects which Spring automatically marshals into JSON format. This ensures a structured and consistent data contract with the client.
*/


@RestController
@RequestMapping(path="/report")
public class reportController {
	
	@Autowired
	private reportService repoService;
	
	
	@GetMapping(path="/statOperazione/{tipo}", produces="application/json")
	public ReportDTO registraOperazione(@PathVariable String tipo) {
		
			return repoService.caratteristicaOperazione(tipo);
	
	}
	
	
	@GetMapping(path="/mostraReport", produces="application/json")
	public ReportDTO mostraReport() {
		
		return repoService.mostraReportTotale();
	
	}
	

	

}
