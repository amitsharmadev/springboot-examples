package com.amit.sample;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.amit.sample.data.Customer;
import com.amit.sample.data.Product;

@SpringBootApplication
@EnableAspectJAutoProxy()  
public class AopBasics1Application  implements CommandLineRunner {

	@Autowired
	Customer customer;
	public static void main(String[] args) {
		SpringApplication.run(AopBasics1Application.class, args);
	}

	@Autowired
	Product product;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	//	customer.setName("Prince");
		System.out.println("**************************");
		customer.setData("Vikram", "101", "Rohini", 90, "ICICI", LocalDate.now());
		
		System.out.println("##############################");
		System.out.println("");
		System.out.println("********************************");
		product.setSomething();
		System.out.println("********************************");
		
		
		
		String d=customer.getName();
		
	}
	
	
	
	
	
}
