package com.amit.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amit.sample.controller.EmployeeRepository;
import com.amit.sample.domain.EmployeeVO;

@SpringBootApplication
public class SpringRestExceptionHandlingApplication implements CommandLineRunner {

	
	@Autowired
	EmployeeRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRestExceptionHandlingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repo.save(new EmployeeVO(101, "Prince", "Kazmi", "prince@gmail.com"));
		repo.save(new EmployeeVO(102, "Vikram", "Kapoor", "vikram@gmail.com"));
		repo.save(new EmployeeVO(103, "Binod", "Anand", "binod@gmail.com"));
		repo.save(new EmployeeVO(104, "Nupur", "Chopra", "nupur@gmail.com"));
		
		
	}

}
