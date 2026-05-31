package it.demo.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@RefreshScope
//@EnableDiscoveryClient // quando si utilizza RestTemplate (senza OpenFeign)
@EnableFeignClients  // quando si utilizza OpenFeign

public class MmQuizRdApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmQuizRdApplication.class, args);
	}

}
