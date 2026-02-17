package com.spring.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* * SpringECommerceApplication - Application Root & Configuration
    ? The central entry point of the Spring Boot application. This class triggers the automated setup of the Spring Framework, initializing the bean container and starting the embedded web server (Tomcat) to listen for incoming E-commerce traffic.

    ! 1. Meta-Annotation Power, uses `@SpringBootApplication`, which combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`. This allows Spring to automatically discover your Controllers, Services, and DAOs within the `com.spring.ecommerce` package hierarchy.
    ! 2. Bootstrap Mechanism, the `main` method invokes `SpringApplication.run()`, launching the internal lifecycle of the application. It handles the environment setup, command-line argument processing, and the creation of the ApplicationContext.
    ! 3. Component Scanning, by residing in the root package, it defines the base search path for the framework. This ensures that every annotated class in your project (like `@Repository` or `@Service`) is correctly instantiated as a managed bean.
*/

@SpringBootApplication
public class SpringECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringECommerceApplication.class, args);
	}

}
