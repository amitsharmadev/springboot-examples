package com.amit.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EServiceApplication.class, args);
	}

}
