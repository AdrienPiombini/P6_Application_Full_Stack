package com.openclassroom.application;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.openclassroom.application.entities.Topic;
import com.openclassroom.application.entities.User;
import com.openclassroom.application.entities.Enum.Role;
import com.openclassroom.application.entities.Enum.Title;
import com.openclassroom.application.repositories.TopicRepository;
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
	CommandLineRunner start(
			UserRepository userRepository,
			TopicRepository topicRepository

	) {
		return args -> {
			Stream.of(Title.BACKEND, Title.FRONTEND, Title.FULLSTACK).forEach(title -> {
				Topic topic = new Topic(title);
				topic.setDescription("a classical description");
				topicRepository.save(topic);
			});

			Stream.of("Adrien", "Foo", "John").forEach(name -> {
				User user = new User();
				user.setEmail(name + "@gmail.com");
				user.setUsername(name);
				user.setPassword(passwordEncoder.encode(name));
				user.setRole(Role.USER);
				userRepository.save(user);
			});

			// Topic topic = topicRepository.getReferenceById(1L);
			// User user = userRepository.getReferenceById(1L);
			// user.setTopics(List.of(topic));
			// userRepository.save(user);
		};
	}

}
