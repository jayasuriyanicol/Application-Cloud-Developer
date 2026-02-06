package com.spring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.ProfessoriDTO;
import com.spring.entity.Professore;
import com.spring.service.ProfessoriService;

/* * ProfessoriController - API Endpoint Management
    ? The web controller handling HTTP requests related to 'Professore' entities, exposing endpoints for CRUD operations and specific data aggregations (sorting, filtering).

    ! 1. registraProf(@RequestBody ...), accepts a Data Transfer Object (DTO) to decouple the external API structure from the internal entity model during the creation process.
    ! 2. cercaProf/cancellaProf(@PathVariable ...), uses dynamic URL segments (e.g., /cercaProf/5) to target specific resources for retrieval or deletion.
    ! 3. aggiornaMateria(...), handles updates to a professor's subject specialization (Materia).
    ! 4. professoriOrdinatiCognome() / tutteMaterieInsegnate(), specific reporting endpoints that return filtered or sorted lists of strings/objects.
*/

/* * Spring Annotations Reference
    ? Technical breakdown of the metadata used to configure the web layer behavior.

    ! 1. @RestController, marks this class as a web-ready bean where every method implicitly uses @ResponseBody. The return values are serialized directly into the HTTP response (usually JSON) instead of rendering an HTML view.
    ! 2. @RequestMapping(path = "/professori"), defines the global parent URI for this controller. All endpoints defined here will be prefixed with "/professori".
    ! 3. @GetMapping, specifically maps HTTP GET requests to these methods. Note: In this implementation, GET is used for all actions (including creation and deletion), whereas standard REST conventions typically use POST for creation, DELETE for removal, and PUT/PATCH for updates.
*/


@RestController
@RequestMapping(path = "/professori")
public class ProfessoriController {

	private ProfessoriService profService = new ProfessoriService();

	@GetMapping(path = "/registraProf", consumes = "application/json")
	public boolean registraProf(@RequestBody ProfessoriDTO professore) {
		return profService.registraProfessore(professore);
	}

	@GetMapping(path = "/cercaProf/{idProf}", produces = "application/json")
	public ProfessoriDTO cercaProf(@PathVariable int idProf) {
		return profService.cercaProfessoreID(idProf);
	}

	@GetMapping(path = "/cancellaProf/{idProf}", produces = "application/json")
	public Professore cancellaProfessore(@PathVariable int idProf) {
		return profService.cancellaProfessore(idProf);
	}

	@GetMapping(path = "/listaProf", produces = "application/json")
	public List<Professore> listaProfessori() {
		return profService.tuttiProfessori();
	}

	@GetMapping(path = "/aggiornaProf/{idProf}", produces = "application/json")
	public Professore aggiornaMateria(@PathVariable int idProf, String nuovaMateria) {
		return profService.nuovaMateriaProfessore(idProf, nuovaMateria);
	}

	@GetMapping(path = "/materieProf/{materia}")
	public List<Professore> materieProfInsegnate(String materia) {
		return profService.insegnamentoProfessoreMateria(materia);
	}

	@GetMapping(path = "/cognomiOrdProf")
	public List<String> professoriOrdinatiCognome() {
		return profService.professoriOrdinatiCognome();
	}

	@GetMapping(path = "/materieInsProf", produces = "application/json")
	public List<String> tutteMaterieInsegnate() {
		return profService.tutteMaterieInsegnate();
	}

}
