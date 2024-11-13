package com.demo.assignment.hyperhire;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@OpenAPIDefinition(
		info = @Info(
				title = "Hyperhire assignment",
				version = "1.0.0",
				termsOfService = "dungnhm",
				contact = @Contact(
						name = "DungNHM",
						email = "dungnhm1998@gmail.com"
				)
		)
)
public class HyperhireApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyperhireApplication.class, args);
	}

}
