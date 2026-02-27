package it.demo.catalogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;


@SpringBootApplication
@RefreshScope
public class MmCatalogoRdApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmCatalogoRdApplication.class, args);
	}

}
