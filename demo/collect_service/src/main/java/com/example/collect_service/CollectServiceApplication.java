package com.example.collect_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CollectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollectServiceApplication.class, args);
	}

}
