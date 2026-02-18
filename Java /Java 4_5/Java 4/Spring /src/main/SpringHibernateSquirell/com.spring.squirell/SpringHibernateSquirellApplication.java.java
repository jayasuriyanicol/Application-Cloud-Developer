package com.spring.squirell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/* * SpringHibernateSquirellApplication - Hibernate Integration Entry Point
    ? The main bootstrapper for the 'Squirrel' module. This class initializes the Spring context with a specific focus on Hibernate ORM (Object-Relational Mapping), bridging the gap between Java objects and the relational database schema.

    ! 1. Automated ORM Configuration, through the `@SpringBootApplication` annotation, Spring detects Hibernate dependencies on the classpath. It automatically configures the `LocalContainerEntityManagerFactoryBean` and the `HibernateTransactionManager`, allowing for seamless interaction with the database without manual XML configuration.
    ! 2. Entity Scanning, serves as the root for component scanning, specifically looking for classes annotated with `@Entity`. This ensures that Hibernate can map the domain model to database tables as soon as the application context is refreshed.
    ! 3. Persistence Lifecycle Management, the `main` method starts the application and orchestrates the creation of the DataSource and Connection Pool. This sets the stage for advanced features like Lazy Loading, Caching, and Transactional integrity that the Squirrel module relies on.
*/


@SpringBootApplication
public class SpringHibernateSquirellApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateSquirellApplication.class, args);
	}

}
