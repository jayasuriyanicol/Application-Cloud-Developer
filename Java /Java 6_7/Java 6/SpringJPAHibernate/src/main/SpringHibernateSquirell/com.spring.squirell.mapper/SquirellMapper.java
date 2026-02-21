package com.spring.squirell.mapper;

import com.spring.squirell.dto.squirellDTO;
import com.spring.squirell.entity.Squirell;


/* * SquirellMapper - Data Transformation Utility
    ? A utility class responsible for the bidirectional conversion between the database Entity and the client-facing DTO. It serves as the "translator" that ensures the persistence layer and the web layer can exchange data without being tightly coupled.

    ! 1. Static Transformation Logic, utilizes static methods to perform direct mapping. This approach avoids the overhead of instantiating a mapper object while providing a centralized, reusable location for all conversion logic, making the code easier to maintain and test.
    ! 2. Encapsulation Protection, by manually copying fields from the `Squirell` entity to the `SquirellDTO`, the mapper ensures that only the intended data is exposed to the API. This prevents internal database details or sensitive entity state from leaking into the JSON response.
    ! 3. Clean Code Architecture, removes the burden of transformation from the Service layer. By delegating the "new Object()" logic to this specialized mapper, the `SquirellService` can stay focused purely on business rules and transaction management.
*/


public class SquirellMapper {

	//We use the static methods here for the conversion

    //Conversion from Squirell DTO -> Squirell Entity
	public static Squirell SquirellDTOToSquirell(SquirellDTO dto) {
	
		return new Squirell(dto.getId(), dto.getNome(), dto.getTipo());
	}
	
    //Conversion from Squirell -> Squirell DTO
	public static SquirellDTO SquirellToSquirellDTO(Squirell e) {
		
		return new SquirellDTO(e.getId(), e.getNome(), e.getTipo());
	}
	
	
	
}
