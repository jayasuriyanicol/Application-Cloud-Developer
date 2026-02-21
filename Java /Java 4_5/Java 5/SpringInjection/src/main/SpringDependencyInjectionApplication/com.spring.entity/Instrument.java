
package com.spring.music.entity;

/* * Instrument - Interface Contract
    ? Defines the abstract behavior for all musical instruments within the application. It serves as the decoupling layer that allows the Spring container to inject different implementations (like Guitar or Drums) without altering the dependent classes.

    ! 1. Polymorphism, ensures that any bean implementing this interface can be interchangeably used where an 'Instrument' is required, enabling flexible dependency injection.
    ! 2. Contract Enforcement, mandates the implementation of the `play()` method, guaranteeing that all specific instruments provide a consistent execution entry point.
*/

public interface Instrument {
	
	public void play();
	
	

}
