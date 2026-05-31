package com.spring.music.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* * Player - Dependency Injection Consumer
    ? Represents a client component that relies on the Spring IoC container to resolve its dependencies. It demonstrates how business logic delegates tasks to injected services without knowing their specific implementation.

    ! 1. @Component, marks this class as a managed bean, allowing Spring to instantiate it and scan it for injection points during application startup.
    ! 2. @Autowired, signals the container to perform Field Injection. Spring searches the context for a bean matching the `Instrument` interface (e.g., `Drums` or `Guitar`) and assigns it here automatically.
    ! 3. Decoupling, the `playInstrument()` method operates on the `Instrument` abstraction, meaning the `Player` works with any instrument implementation provided by the container.
*/

//In this case, we create the annotation Component as the father 
@Component
public class Player {
	
	//Adding the the @Autowired to indicate the 'injection' method
	@Autowired
	private Instrument instrument;
	
	public void playInstrument() {
		
		instrument.play();
	}
		
	

}
