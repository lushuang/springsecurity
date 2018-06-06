package com.lushuang.springsecuritydemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Springsecuritydemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springsecuritydemo1Application.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "Hello Spring Boot!";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("hello")
	public String hello() {
		return "Hello Spring Security!!";
	}
}
