package com.example.CRUDTutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.CRUDTutorial.Model")
public class CrudTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudTutorialApplication.class, args);
	}

}
