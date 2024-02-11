package com.msansar.userservice;

import com.msansar.userservice.dto.UserSaveRequestDto;
import com.msansar.userservice.model.User;
import com.msansar.userservice.repository.UserRepository;
import com.msansar.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class UserServiceApplication {

	private UserService userService;

	public UserServiceApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
