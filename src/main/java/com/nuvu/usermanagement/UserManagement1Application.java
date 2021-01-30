package com.nuvu.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class UserManagement1Application {

	public static void main(String[] args) {
		SpringApplication.run(UserManagement1Application.class, args);
	}

}
