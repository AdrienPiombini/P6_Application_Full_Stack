package com.openclassroom.application;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.openclassroom.application.entities.Role;
import com.openclassroom.application.entities.User;
import com.openclassroom.application.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor // to Remove
public class Application {
	final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner start(UserRepository userRepository) {
		return args -> {
			Stream.of("Adrien", "Foo", "John").forEach(name -> {
				User user = new User();
				user.setEmail(name + "@gmail.com");
				user.setUsername(name);
				user.setPassword(passwordEncoder.encode(name));
				user.setRole(Role.USER);
				userRepository.save(user);
			});
		};
	}

}
