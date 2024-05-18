package com.satdegerlendir.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SatDegerlendirApplication {

	public static void main(String[] args) {
		SpringApplication.run(SatDegerlendirApplication.class, args);
	}

}
