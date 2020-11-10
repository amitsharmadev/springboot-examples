package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repo.Employee;
import com.example.demo.repo.EmployeeRepo;

@RestController
public class EmployeeController {

	@Autowired EmployeeRepo empRepo;
	
	@GetMapping("/")
	public List<Employee> getEmployees(){
		return empRepo.findAll();
	}
	@PostMapping("/")
	public Employee saveEmployees(@RequestBody Employee e){
		return empRepo.save(e);
	}
	@GetMapping("/{code}")
	public Employee getEmployeeById(@PathVariable int code){
		return empRepo.findById(code).get();
	}
}
