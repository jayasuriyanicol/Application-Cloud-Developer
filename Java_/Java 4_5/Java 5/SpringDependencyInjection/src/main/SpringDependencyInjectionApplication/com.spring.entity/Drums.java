package com.spring.music.entity;

import org.springframework.context.annotation.Primary;
//We add the @SuppressWarnings -> "unused" because it can be implemented as weel replacing the @Primary with -> @Component
import org.springframework.stereotype.Component;


/* * Drums - Primary Bean Implementation
    ? Concrete implementation of the `Instrument` interface representing a Drum kit. It is specifically marked to resolve dependency injection ambiguity when multiple `Instrument` implementations exist in the Spring context.

    ! 1. @Primary, designates this specific bean as the default candidate for autowiring. If the container finds multiple beans of type `Instrument` (e.g., Guitar, Piano, Drums), it injects this one to avoid a `NoUniqueBeanDefinitionException`.
    ! 2. Polymorphism, overrides the `play()` method to provide specific behavior, demonstrating how Spring manages interface-based dependency injection.
*/


//Here we have two type of creation: 1. @Component as comment, because we can't have two components in implemented class 2. Using the @Primary to flag the class as the priority one
@SuppressWarnings("unused")
@Primary
public class Drums implements Instrument {
	
	
	//Adding the default method that is a priority on the child class
	@Override
	public void play() {
		
		System.out.println("I playing the drums ! ");
	}

}
