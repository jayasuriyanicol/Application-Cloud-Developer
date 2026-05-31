package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.music.entity.Player;


/* * SpringDependencyInjectionApplication - IoC Container Entry Point
    ? Bootstraps the Spring Boot application and demonstrates the core principle of Inversion of Control (IoC). Instead of manually instantiating objects with 'new', it asks the Spring Container to provide the fully constructed beans.

    ! 1. ApplicationContext, captures the return value of 'run()', representing the active IoC container that holds all managed beans and their configuration.
    ! 2. context.getBean(Player.class), explicitly retrieves the 'Player' bean from the container context. This proves that Spring has already created the object and injected its dependencies (the Instrument).
    ! 3. player.playInstrument(), executes the business logic on the managed bean, confirming that the dependency graph was successfully resolved and the object is ready for use.
*/


@SpringBootApplication
public class SpringDependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(SpringDependencyInjectionApplication.class, args);
		
		
		Player player = context.getBean(Player.class);
		
		player.playInstrument();
	
	}

}
