package com.caring.caring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CaringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaringApplication.class, args);
	}

}
