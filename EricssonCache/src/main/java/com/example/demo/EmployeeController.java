package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return empRepo.findAll();
	}
	@GetMapping("/employees/{address}")
	public List<Employee> getEmployeesByAddress(@PathVariable String address){
		return empRepo.findByAddress(address);
	}
	@DeleteMapping("/employees/{address}")
	public List<Employee> deleteEmployeesByAddress(@PathVariable String address){
		return empRepo.deleteAndRecache(address);
	}
	
	

}
