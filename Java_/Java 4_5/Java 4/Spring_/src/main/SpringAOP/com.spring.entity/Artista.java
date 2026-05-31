package com.spring.aop.entity;

import java.util.Random;

import org.springframework.stereotype.Component;

/* * Artista - AOP Target Component
    ? Represents a Spring-managed domain entity acting as the primary target for Aspect-Oriented Programming (AOP). It simulates a business process that can randomly succeed or fail to trigger different Aspect advices.

    ! 1. @Component, registers the class in the application context, allowing Spring AOP to wrap it with a proxy and intercept its method executions.
    ! 2. perform() & Random Failure, the method serves as the specific "Join Point". It intentionally uses a random boolean to either print a success message or throw a RuntimeException, effectively enabling the testing of both @AfterReturning and @AfterThrowing aspects.
*/


//Here we add the @Component
@Component
public class Artista {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void perform() {
		
		if(new Random().nextBoolean())
			System.out.println(nome + " sta eseguendo la sua performance");
		else 
			throw new RuntimeException();
	}
	
	
	
}
