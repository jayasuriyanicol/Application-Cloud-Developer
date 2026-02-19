package com.spring.impiegati;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/* * SpringImpiegatiJpaApplication - Employee Management Context Root
    ? The entry point for the "Impiegati" (Employee) JPA module. This class initializes the Spring Boot environment, specifically bootstrapping the persistence context and auto-configuration required to manage employee-related relational data.

    ! 1. Microservice-Style Isolation, by creating a dedicated application class for the 'Impiegati' package, the project maintains a modular structure. This allows the Employee management logic to operate as a focused service within the larger Spring ecosystem.
    ! 2. Automatic Component Discovery, the `@SpringBootApplication` annotation ensures that Spring scans the `com.spring.impiegati` sub-packages for JPA Entities, Repositories, and Services, automatically wiring the necessary dependencies for database interaction.
    ! 3. Persistence Configuration, this bootstrap class triggers the loading of `application.properties`, establishing the connection to the employee database and initializing the Hibernate SessionFactory required for mapping Employee objects to SQL tables.
*/


@SpringBootApplication
public class SpringImpiegatiJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringImpiegatiJpaApplication.class, args);
	}

}
