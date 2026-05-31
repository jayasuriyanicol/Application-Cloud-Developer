package it.demo.catalogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@RefreshScope
@EnableFeignClients(basePackages = "it.demo.catalogo.service.client")

public class MmCatalogoRdApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmCatalogoRdApplication.class, args);
	}

}
