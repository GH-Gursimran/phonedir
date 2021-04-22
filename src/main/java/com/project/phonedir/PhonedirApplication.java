package com.project.phonedir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PhonedirApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhonedirApplication.class, args);
	}

}
