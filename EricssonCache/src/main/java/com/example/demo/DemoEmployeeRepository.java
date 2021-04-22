package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.event.ListSelectionEvent;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class DemoEmployeeRepository implements EmployeeRepository {

	public DemoEmployeeRepository() {
//		employees.add(new Employee(101,"Prince","Delhi"));
//		employees.add(new Employee(102,"Nupur","Jaipur"));
//		employees.add(new Employee(103,"Mansi","Mumabi"));
//		employees.add(new Employee(104,"Vaibhav","Delhi"));
//		employees.add(new Employee(105,"Vikas","Mumbai"));
//		
	}
	//List<Employee> employees=new ArrayList<Employee>();
	List<Employee> employees=List.of(
			new Employee(101,"Prince","Delhi"),
			new Employee(102,"Nupur","Jaipur"),
			new Employee(103,"Mansi","Mumabi"),
			new Employee(104,"Vaibhav","Delhi"),
			new Employee(105,"Vikas","Mumbai")
			);
			
	
	@Override
	@Cacheable("employees")
	public List<Employee> findAll() {
		simulateFetch();
		return this.employees;
	}

	@Override
	@Cacheable("employees")
	public List<Employee> findByAddress(String address) {
		simulateFetch();
		return this.employees.stream()
		.filter(e->e.getAddress()
				.equals(address)).collect(Collectors.toList());
		 
	}

	@Override
	@Cacheable("employee")
	public Employee findById(int empId) {	
		simulateFetch();
		return this.employees.stream().filter(e-> e.getEmpId()==empId).findFirst().get();
	}
	
	public void simulateFetch()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	@CacheEvict(value = "employees",allEntries = true,beforeInvocation = true)
	@Cacheable(value = "employees", key = "T(org.springframework.cache.interceptor.SimpleKey).EMPTY")
	public List<Employee> deleteAndRecache(String address) {
		List<Employee> temp=new ArrayList<Employee>(this.employees);
		temp.removeIf(e->e.getAddress().equals(address));
		return temp ;
	}

}
