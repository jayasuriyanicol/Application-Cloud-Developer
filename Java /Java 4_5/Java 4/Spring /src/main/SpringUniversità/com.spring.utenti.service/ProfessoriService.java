package com.spring.service;

import java.util.List;

import com.spring.dao.ProfessoriDAO;
import com.spring.dto.ProfessoriDTO;
import com.spring.entity.Professore;

/* * ProfessoriService - Business Logic & Mapping Layer
    ? Acts as the middleware between the web controller and the data access layer (DAO), handling data transformation and business rules.

    ! 1. DTO Mapping, explicitly handles the conversion between Data Transfer Objects (ProfessoriDTO) and Domain Entities (Professore). This ensures that the internal database structure is not directly exposed to the API layer (seen in 'registraProfessore' and 'cercaProfessoreID').
    ! 2. nuovaMateriaProfessore(...), encapsulates specific update logic by verifying the professor's existence, removing the old record, updating the field, and re-persisting the entity.
    ! 3. Delegation, serves as a facade for read operations ('tuttiProfessori', 'insegnamentoProfessoreMateria'), forwarding requests directly to the underlying DAO.
*/

public class ProfessoriService {
	
	private ProfessoriDAO daoProfessori= new ProfessoriDAO();
	
	
	public boolean registraProfessore(ProfessoriDTO dto) {
		
		if(dto == null) return false;
		
		Professore professore = new Professore();
		professore.setId(dto.getId());
		professore.setNome(dto.getNome());
		professore.setCognome(dto.getCognome());
		professore.setMateriaInsegnamento(dto.getMateriaInsegnamento());
	    
		

		return daoProfessori.registraProfessore(professore);
		
		
	}
	
	
	public ProfessoriDTO cercaProfessoreID(Integer idProf) {
		
		Professore p = daoProfessori.cercaProfessoreID(idProf);
		
		return new ProfessoriDTO(p.getId(), p.getNome(), p.getCognome(), p.getMateriaInsegnamento());
		
	}
	
	

	public List<Professore> tuttiProfessori() {
		
		return daoProfessori.listaProfessori();
		
	}

	public Professore cancellaProfessore (int idProf) {
		
		return daoProfessori.cancellaProfessore(idProf);
	}

	
	public Professore nuovaMateriaProfessore (int idProf, String nuovaMateria) {
		
		if (cercaProfessoreID(idProf) == null)
			return null;
		
		Professore professoreCancellato = daoProfessori.cancellaProfessore(idProf);
		professoreCancellato.setMateriaInsegnamento(nuovaMateria);
		daoProfessori.registraProfessore(professoreCancellato);
		
		
		return professoreCancellato;
	}

	public List<Professore> insegnamentoProfessoreMateria(String materia) {
		
		return daoProfessori.insegnamentoProfessoreMateria(materia);
	}

	public List<String> professoriOrdinatiCognome () {
		
		return daoProfessori.professoriOrdinatiCognome();
	}

	
	public List<String> tutteMaterieInsegnate () {
		
		return daoProfessori.tutteMaterieInsegnate();
	}

}
	
	
	
	
	
	
	
	
	
	