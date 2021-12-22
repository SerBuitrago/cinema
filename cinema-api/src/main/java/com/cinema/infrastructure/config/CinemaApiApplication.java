package com.cinema.infrastructure.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.cinema.infrastructure")
@EntityScan(basePackages = "com.cinema.domain.entity")
public class CinemaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaApiApplication.class, args);
	}
}
