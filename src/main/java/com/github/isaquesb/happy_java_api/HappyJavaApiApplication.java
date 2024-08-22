package com.github.isaquesb.happy_java_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class HappyJavaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyJavaApiApplication.class, args);
	}
}
