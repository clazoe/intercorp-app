package com.intercorp.customercare.backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Claims API",version="1.0",description = "Claim Backend for Intercorp's Customer Care"))
public class CustomercareBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomercareBackendApplication.class, args);
	}

}
