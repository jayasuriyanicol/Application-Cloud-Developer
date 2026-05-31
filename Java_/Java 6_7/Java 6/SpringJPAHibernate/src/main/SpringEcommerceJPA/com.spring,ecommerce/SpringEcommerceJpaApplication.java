package com.spring.ecommerce;


/* * SpringEcommerceJpaApplication - JPA Ecosystem Entry Point
    ? The main bootstrap class for the JPA-enabled E-commerce module. It initializes the Spring Framework's auto-configuration engine, specifically setting up the Persistence Context and Hibernate-to-Database mapping for the electronic commerce domain.

    ! 1. Unified Configuration Root, by utilizing the `@SpringBootApplication` annotation, this class acts as the centralized configuration hub. it combines component scanning, auto-configuration for data sources, and JPA repository enablement, ensuring all sub-packages are correctly registered within the Spring container.
    ! 2. Persistence Layer Initialization, the `main` method triggers the instantiation of the `EntityManagerFactory`. This process establishes the connection pool and verifies that the Java entities are correctly mapped to the underlying relational database schema before the web server begins accepting requests.
    ! 3. Strategic Component Scanning, residing in the base `com.spring.ecommerce` package, it defines the scan boundaries for the entire application. This ensures that every `@Repository`, `@Service`, and `@RestController` in the project is automatically discovered and managed as a Spring Bean.
*/


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringEcommerceJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEcommerceJpaApplication.class, args);
	}

}
