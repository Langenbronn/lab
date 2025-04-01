package com.lab.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.lab.jpa")
public class ProjectJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectJpaApplication.class, args);
	}

}
