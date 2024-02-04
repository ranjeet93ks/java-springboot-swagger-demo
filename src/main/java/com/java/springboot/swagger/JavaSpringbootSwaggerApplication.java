package com.java.springboot.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Book API", version = "1.0", description = "Book Microservice"))
public class JavaSpringbootSwaggerApplication {
	
	//springdoc.api-docs.path=/book-docs --in application.properties
	//http://localhost:8089/book-docs -> for swagger console
	//http://localhost:8089/book-docs.yaml --will download .yaml file
	//http://localhost:8089/swagger-ui/index.html --> list of all endpoints defined in controller 
	//and there we can test as well
	

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringbootSwaggerApplication.class, args);
	}

}
