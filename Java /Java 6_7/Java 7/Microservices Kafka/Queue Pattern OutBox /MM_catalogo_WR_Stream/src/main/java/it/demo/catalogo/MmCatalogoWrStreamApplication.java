package it.demo.catalogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class MmCatalogoWrStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmCatalogoWrStreamApplication.class, args);
	}

}
