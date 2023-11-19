package com.bd.trabalhoBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Trabalho de BD1", version = "1.0.0", description = "API feita para obtensão da nota da disciplina de banco de dados 1"))
public class TrabalhoBdApplication {
	public static void main(String[] args) {
		SpringApplication.run(TrabalhoBdApplication.class, args);
	}

}
