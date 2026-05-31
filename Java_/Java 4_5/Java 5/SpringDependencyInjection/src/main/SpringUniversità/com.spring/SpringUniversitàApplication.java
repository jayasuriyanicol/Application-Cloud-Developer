package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/* * SpringUniversitaApplication - Application Bootstrapper
    ? The main entry point for the University management Spring Boot application, initializing the Spring container and triggering auto-configuration.

    ! 1. @SpringBootApplication, a meta-annotation that combines @Configuration, @EnableAutoConfiguration, and @ComponentScan to configure the application context automatically.
    ! 2. main(String[] args), launches the application by passing this class to the SpringApplication.run() helper method.
*/

@SpringBootApplication
public class SpringUniversitaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringUniversitaApplication.class, args);
	}

}
