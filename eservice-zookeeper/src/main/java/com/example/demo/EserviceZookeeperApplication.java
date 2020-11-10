package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class EserviceZookeeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(EserviceZookeeperApplication.class, args);
	}

	@GetMapping("/data")
	public String getData() {
	    return "Microservice Returing some data";
	}
}
