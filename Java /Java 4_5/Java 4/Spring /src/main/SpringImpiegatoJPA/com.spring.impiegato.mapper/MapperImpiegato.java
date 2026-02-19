package com.spring.impiegati.mapper;
import com.spring.impiegati.entity.Impiegato;
import com.spring.impiegati.dto.ImpiegatoDTO;


/* * MapperImpiegato - HR Data Transformation Utility
    ? A dedicated translation layer that facilitates the conversion between the 'Impiegato' database Entity and its corresponding DTO. This utility ensures that data flows seamlessly between the persistence layer and the REST controller while maintaining strict architectural boundaries.

    ! 1. Stateless Conversion Logic, utilizes static methods to perform direct mapping. By avoiding internal state, the mapper provides a thread-safe and high-performance mechanism to transform employee records without the overhead of object instantiation for the utility class itself.
    ! 2. Constructor-Based Mapping, leverages the full-parameter constructors of both the Entity and DTO. This ensures that all critical employee data—including names, company ID (matricola), and hiring timestamps—are accurately transferred in a single atomic operation during the conversion process.
    ! 3. Architectural Decoupling, serves as the "buffer" that protects the API contract. If the database schema for the 'Impiegato' table changes (e.g., adding a middle name or department code), the changes are contained within this mapper, preventing a "ripple effect" that would break the frontend's expected JSON structure.
*/

public class MapperImpiegato {
	
	
	public static Impiegato ImpiegatoDTOToEntity(ImpiegatoDTO dto) {
		
		return new Impiegato(dto.getNome(), dto.getCognome(),dto.getMatricola(),dto.getSalarioMensile(),dto.getDataAssunzione());
	}
	
	public static ImpiegatoDTO ImpiegatoEntityToDTO(Impiegato entity) {
		
		return new ImpiegatoDTO(entity.getNome(), entity.getCognome(),entity.getMatricola(),entity.getSalarioMensile(),entity.getDataAssunzione());
	}

}
