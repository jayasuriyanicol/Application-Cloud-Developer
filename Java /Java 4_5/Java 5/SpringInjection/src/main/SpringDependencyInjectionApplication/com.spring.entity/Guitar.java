package com.spring.music.entity;

//We add the @SuppressWarnings -> "unused" because it can be implemented as weel replacing the @Component with -> @Primary
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


/* * Guitar - Component Bean Implementation
    ? Represents a concrete implementation of the `Instrument` interface managed by the Spring IoC container. It serves as a standard candidate for dependency injection.

    ! 1. @Component, marks this class as a Spring-managed bean, allowing the classpath scanner to automatically detect, instantiate, and register it in the application context.
    ! 2. Injection Candidate, unlike a `@Primary` bean, this implementation acts as a secondary option. It requires explicit selection (e.g., via `@Qualifier`) if multiple `Instrument` beans exist to avoid ambiguity.
*/


@SuppressWarnings("unused")
@Component
public class Guitar implements Instrument {
	
	
	//Adding the default method that is a priority on the child class
	@Override
	public void play() {
		
		System.out.println("I playing the guitar ! ");
	}

}
