package com.konex.servapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Konex24Application {

	public static void main(String[] args) {
		SpringApplication.run(Konex24Application.class, args);
		System.err.println("APPLICATION STARTED ================================================");
	}
}
