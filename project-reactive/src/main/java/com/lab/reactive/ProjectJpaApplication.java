package com.lab.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.lab.reactive")
public class ProjectJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectJpaApplication.class, args);
	}

}
