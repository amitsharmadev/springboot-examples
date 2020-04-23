package com.amit.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	RestTemplate restTemplate=new RestTemplate();
	
	@HystrixCommand(fallbackMethod = "fallbackMethodForEmployee")
	public Employee saveEmployee(Employee e) {
		
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.add("test_header", "test_header");
		HttpEntity<String> httpEntity=new HttpEntity<String>(e.toString(), httpHeaders);
		restTemplate.exchange("http://localhost:8989/approve", HttpMethod.PUT,httpEntity,String.class);
		
		return employeeRepository.save(e);
	} 
	
	public Employee fallbackMethodForEmployee(Employee e) {
		return e.setResponse("our system is under maintanence, but we are unable to process request now!!!");
	}
	
}


