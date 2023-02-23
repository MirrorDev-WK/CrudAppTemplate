package com.mirrordev.crudapptemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CrudapptemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudapptemplateApplication.class, args);
	}

}
