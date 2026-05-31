package com.spring.statistiche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/* * SpringStatisticheCalcoloApplication - Application Bootstrap & Configuration
    ? The main entry point for the Spring Boot application, responsible for initializing the Spring container, auto-configuring beans, and starting the application lifecycle.

    ! 1. @SpringBootApplication, a convenience annotation that combines @Configuration, @EnableAutoConfiguration, and @ComponentScan. It tells Spring to look for components, configurations, and services in the 'com.spring.statistiche' package and its sub-packages.
    ! 2. SpringApplication.run(...), the static method that launches the application. It creates the ApplicationContext, performs class-path scanning, and starts the embedded web server (like Tomcat) if web dependencies are present.
*/

@SpringBootApplication
public class SpringStatisticheCalcoloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStatisticheCalcoloApplication.class, args);
	}

}
