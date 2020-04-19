package com.amit.sample;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amit.sample.data.ProductRepository;
import com.amit.sample.domain.Product;

@SpringBootApplication
public class SpringRest2Application implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringRest2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		productRepository.save(new Product(101L, "Monitor", "Electronics Product cosumer is specially Technical people", new BigDecimal(15000)));
		productRepository.save(new Product(102L, "Mouse", "Electronics Product cosumer is specially Technical people", new BigDecimal(2500)));
		productRepository.save(new Product(103L, "Laptop", "Electronics Product cosumer is specially Technical people", new BigDecimal(50000)));
		productRepository.save(new Product(104L, "Printer", "Electronics Product cosumer is specially Technical people", new BigDecimal(25000)));
	}

}
