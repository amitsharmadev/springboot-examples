package com.amit.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringRestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestClientApplication.class, args);
		getEmployees();
		createEmployee();
		updateEmployee();
	}

	
	
	private static void getEmployees()
	{
	    final String uri = "http://localhost:9090/employees.xml";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	     
	    System.out.println(result);
	    
	}
	
	
	private static void getEmployees1()
	{
	    final String uri = "http://localhost:9090/employees.json";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	     
	    System.out.println(result);
	}
	
	
	private static void createEmployee()
	{
	    final String uri = "http://localhost:9090/employees";
	 
	    EmployeeVO newEmployee = new EmployeeVO(901, "Mohit", "Dhawan", "mohin@gmail.com");
	 
	    RestTemplate restTemplate = new RestTemplate();
	    EmployeeVO result = restTemplate.postForObject( uri, newEmployee, EmployeeVO.class);
	 
	    System.out.println(result);
	}
	
	
	
	private static void getEmployees2()
	{
	    final String uri = "http://localhost:9090/employees";
	     
	    RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	     
	    System.out.println(result);
	}
	
	private static void updateEmployee()
	{
	    final String uri = "http://localhost:9090/employees/{id}";
	     
	    Map<String, Integer> params = new HashMap<String, Integer>();
	    params.put("id", 901);
	     
	    EmployeeVO updatedEmployee = new EmployeeVO(901, "Manisha", "Sharma", "manish@email.com");
	     
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.put ( uri, updatedEmployee, params);
	}
	
	private static void deleteEmployee()
	{
	    final String uri = "http://localhost:9090/employees/{id}";
	     
	    Map<String, Integer> params = new HashMap<String, Integer>();
	    params.put("id", 901);
	     
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.delete ( uri,  params );
	}

}
