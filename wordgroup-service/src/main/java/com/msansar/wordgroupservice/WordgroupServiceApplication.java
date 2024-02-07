package com.msansar.wordgroupservice;

import com.msansar.wordgroupservice.model.WordGroup;
import com.msansar.wordgroupservice.repository.WordGroupRepository;
import com.msansar.wordgroupservice.service.WordGroupService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class WordgroupServiceApplication {
	private WordGroupService wordGroupService;

	public static void main(String[] args) {
		SpringApplication.run(WordgroupServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

		};
	}
}
