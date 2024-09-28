package com.example.usermanagementsystem;

import com.example.usermanagementsystem.Config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

@ComponentScan(basePackages = "com.example.usermanagementsystem")
public class UsermanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermanagementsystemApplication.class, args);
	}

}
