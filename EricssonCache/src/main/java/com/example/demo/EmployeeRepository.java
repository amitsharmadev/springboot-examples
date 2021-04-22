package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository {

	List<Employee> findAll();
	List<Employee> findByAddress(String address);
	Employee findById(int empId);
	List<Employee> deleteAndRecache(String address);
	
}
