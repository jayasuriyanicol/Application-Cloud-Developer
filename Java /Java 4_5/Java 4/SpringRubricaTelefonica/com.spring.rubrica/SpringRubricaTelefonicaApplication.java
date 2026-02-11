package com.spring.rubrica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/* * SpringRubricaTelefonicaApplication - Application Bootstrap
    ? The entry point for the "Rubrica Telefonica" (Phonebook) application. It orchestrates the startup process, initializes the Spring Container, and triggers the auto-configuration mechanisms.

    ! 1. @SpringBootApplication, a powerful meta-annotation that bundles @Configuration, @EnableAutoConfiguration, and @ComponentScan. It serves as the directive to scan this package (and sub-packages) for managed beans and controllers.
    ! 2. SpringApplication.run(...), the execution command that bootstraps the application, creates the ApplicationContext, and launches the embedded server (e.g., Tomcat) to handle incoming web requests.
*/


@SpringBootApplication
public class SpringRubricaTelefonicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRubricaTelefonicaApplication.class, args);
	}

}
