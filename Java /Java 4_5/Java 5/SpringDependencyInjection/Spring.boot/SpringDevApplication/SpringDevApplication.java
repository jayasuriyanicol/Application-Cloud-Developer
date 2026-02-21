package Spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* * SpringDevApplication - Spring Boot Entry Point
    ? The main class responsible for bootstrapping the application, annotated with @SpringBootApplication to enable auto-configuration and component scanning.

    ! 1. main(String[] args), invokes SpringApplication.run() to launch the application, initialize the Spring Context, and start the embedded web server.
*/


@SpringBootApplication
public class SpringDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDevApplication.class, args);
	}

}
