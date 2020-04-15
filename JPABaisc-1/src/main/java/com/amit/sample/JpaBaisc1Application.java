package com.amit.sample;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.amit.sample.data.Customer;
import com.amit.sample.repo.CustomerRepository;
import com.amit.sample.repo.CustomerSortPageRepo;

@SpringBootApplication
public class JpaBaisc1Application implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaBaisc1Application.class, args);
	}

	@Autowired
	CustomerSortPageRepo custSortPageRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		customerRepository.save(new Customer("Prince", "101", "Rohini", 45, "ICICI", LocalDate.now()));
		customerRepository.save(new Customer("Vikram", "102", "Vasant Kunj", 45, "ICICI", LocalDate.now()));
		customerRepository.save(new Customer("Vishal", "103", "Mumbai", 45, "ICICI", LocalDate.now()));
		customerRepository.save(new Customer("Vikas", "104", "Mumbai", 45, "ICICI", LocalDate.now()));
		customerRepository.save(new Customer("Vaibhav", "105", "Rohini", 45, "HDFC", LocalDate.now()));
		customerRepository.save(new Customer("Mohit", "106", "Rohini", 45, "ICICI", LocalDate.now()));
		customerRepository.save(new Customer("Princess", "107", "Mumbai", 45, "HDFC", LocalDate.now()));
		customerRepository.save(new Customer("Nupur", "108", "Vasant Kunj", 45, "ICICI", LocalDate.now()));
		customerRepository.save(new Customer("Deepa", "109", "Chandigarh", 45, "ICICI", LocalDate.now()));
		
		
//		System.out.println("");
//		System.out.println("################# Returning All Customer ########################");
//		customerRepository.findAll().stream().forEach(c -> System.out.println(c));
//		System.out.println("#################  Exiting Fetching All       ########################");
//		System.out.println("");

//		System.out.println("");
//		System.out.println(customerRepository.findById("104"));
//		System.out.println("");
////		
//		
//		System.out.println("");
//		System.out.println(customerRepository.findNameById("104"));
//		System.out.println("");
////		
//		System.out.println("");
//		System.out.println(customerRepository.findNameUsingId("104").get());
//		System.out.println("");
//		
//		System.out.println("");
//		customerRepository.findByAddressAndBank("Mumbai", "HDFC").stream().forEach(c->System.out.println(c));
//		System.out.println("");
//		
//		System.out.println("");
//		customerRepository.fetchByAddress("Mumbai").stream().forEach(c->System.out.println(c));
//		System.out.println("");
//		
//		
//		
//		
		System.out.println("");		
		Pageable paging=PageRequest.of(0,4,Sort.by(Direction.ASC,"name"));
		
		 while(true){
	          Page<Customer> page = custSortPageRepo.findAll(paging);
	          System.out.println("Page no: "+page.getNumber());
	          page.getContent().forEach(System.out::println);
	          
	          if(!page.hasNext()){
	              break;
	          }
	          paging = page.nextPageable();
	      }
		
		
		System.out.println("");
//		
//		
//		
//		
		

	}

}
