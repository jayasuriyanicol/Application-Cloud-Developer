package com.spring.squirell.service;
import java.util.List;
import com.spring.squirell.dto.SquirellDTO;

/* * SquirellService - Service Layer Contract
    ? An interface that defines the high-level business operations for the 'Squirrel' module. It acts as the functional blueprint for the application, ensuring that the Controller only interacts with a set of well-defined, standardized methods.

    ! 1. Domain-Driven Abstraction, by strictly using `SquirellDTO` in its signatures, the interface prevents the web layer from ever touching the database Entity directly. This "contract-first" approach ensures that business logic remains the sole authority on how data is exposed or modified.
    ! 2. Standardized CRUD Protocol, establishes a consistent set of operations—`registra`, `cercaPerID`, `cercaTutti`, and `eliminaPerId`. This provides a predictable structure for developers to implement, whether the backend is powered by JPA, a flat file, or an external API.
    ! 3. Orchestration Readiness, serves as the target for the Controller's `@Autowired` injection. This allows the system to easily swap out implementations or apply cross-cutting concerns (like `@Transactional` or logging aspects) without changing the Controller's method calls.
*/


public interface SquirellService {
	
	public void registra(SquirellDTO dto);
	public SquirellDTO cercaPerID(int id);
	public List<SquirellDTO> cercaTutti();
	public void eliminaPerId(int id);
	

}
