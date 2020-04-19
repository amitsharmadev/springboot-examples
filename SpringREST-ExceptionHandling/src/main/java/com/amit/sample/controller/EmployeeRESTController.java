package com.amit.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amit.sample.ResourceNotFoundException;
import com.amit.sample.domain.EmployeeVO;

@RestController
public class EmployeeRESTController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping(value = "/employees")
	public ResponseEntity<EmployeeVO> addEmployee (@RequestBody EmployeeVO employee)
	{
		
		System.out.println("Coming;;;;;");
		employeeRepository.save(employee);
	    return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
	}
	 
	
	@GetMapping(value = "/employees") 
	public ResponseEntity<List<EmployeeVO>> getEmployee()
	{
	    List<EmployeeVO> employee = employeeRepository.findAll();
	     
	    if(employee == null) {
	         throw new ResourceNotFoundException("Invalid employee id : ");
	    }
	    return new ResponseEntity<List<EmployeeVO>>(employee, HttpStatus.OK);
	}
	@GetMapping(value = "/employees/{id}") 
	public ResponseEntity<EmployeeVO> getEmployeeById (@PathVariable("id") int id)
	{
	    EmployeeVO employee = employeeRepository.findById(id).get();
	     
	    if(employee == null) {
	         throw new ResourceNotFoundException("Invalid employee id : " + id);
	    }
	    return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
	}
	@PutMapping(value = "/employees/{id}") 
	public ResponseEntity<EmployeeVO> updateEmployeeById (@PathVariable("id") int id,
			@RequestBody EmployeeVO emp)
	{
	    EmployeeVO employee = employeeRepository.save(emp);
	     
	    if(employee == null) {
	         throw new ResourceNotFoundException("Invalid employee id : " + id);
	    }
	    return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
	}
	
	
	
}
