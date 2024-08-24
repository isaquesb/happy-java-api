package com.github.isaquesb.happy_java_api;

import com.github.isaquesb.happy_java_api.services.FileStorage;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class HappyJavaApiApplication implements CommandLineRunner {

	@Resource
	FileStorage fileStorage;

	public static void main(String[] args) {
		SpringApplication.run(HappyJavaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileStorage.init();
	}
}
