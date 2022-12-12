package com.ojt.bs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class OjtProjectApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(OjtProjectApplication.class, args);
	}

}
