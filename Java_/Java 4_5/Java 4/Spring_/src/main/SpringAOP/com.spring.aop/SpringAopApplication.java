package com.spring.aop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.aop.entity.Artista;

/* * SpringAopApplication - AOP Demonstration Entry Point
    ? Bootstraps the Spring Boot application designed to showcase Aspect-Oriented Programming (AOP). It retrieves an 'Artista' bean from the context to trigger business logic that will be intercepted by aspects.

    ! 1. Context Retrieval, obtains the 'ApplicationContext' to manually fetch beans, simulating a client interacting with the service layer.
    ! 2. Bean Interaction, sets the state ('Ligabue') and invokes 'perform()'. In an AOP context, this method call is the "Join Point" where "Advice" (additional behavior like logging or security checks) is woven in.
*/

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
	ApplicationContext context	= SpringApplication.run(SpringAopApplication.class, args);
	
	// Constructor with 0 arguments
	Artista artista = context.getBean(Artista.class);
	artista.setNome("Ligabue");
	
	artista.perform();
	}
	
	

	
	
}
