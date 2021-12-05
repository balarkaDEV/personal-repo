package com.brahma.bookmaster.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.brahma.bookmaster.service.repository")
@SpringBootApplication
public class BookDetailsServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookDetailsServiceApplication.class, args);
	}
}
