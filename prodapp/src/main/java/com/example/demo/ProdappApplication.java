package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repo.Employee;
import com.example.demo.repo.EmployeeRepo;

@SpringBootApplication
public class ProdappApplication implements CommandLineRunner {

	@Autowired EmployeeRepo empRepo;
	public static void main(String[] args) {
		SpringApplication.run(ProdappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		empRepo.save(new Employee(101,"Arun Kaul",90900));
		empRepo.save(new Employee(102,"Vishal Aggarwal",90900));
		empRepo.save(new Employee(103,"Vikram Kapoor",90900));
		empRepo.save(new Employee(104,"Deepa Suneja",90900));
		empRepo.save(new Employee(105,"Nupur Kaul",90900));
		
	}

}
