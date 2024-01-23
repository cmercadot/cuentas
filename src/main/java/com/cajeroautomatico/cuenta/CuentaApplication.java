package com.cajeroautomatico.cuenta;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CuentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuentaApplication.class, args);
	}



	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("API Gestion de Cuenta ")
						.version("1.0.0")
						.description("API para interactuar con las cuentas")
						.termsOfService("Ninguno")
						.license(new License().name("spring.io").url("https://spring.io/projects/spring-boot/")));

	}

}
