package com.usa.reto3completoMiguel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = {"com.usa.reto3completoMiguel.modelentidades"})
@SpringBootApplication
public class Reto3completoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Reto3completoApplication.class, args);                
	}
}
