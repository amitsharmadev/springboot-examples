package com.amit.sample.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id",scope = Employee.class)
public class Employee {
	
	String name;
	
	int empId;

	public Employee(String name, int empId) {
		super();
		this.name = name;

		this.empId = empId;
	}

	public Employee() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + "]";
	}

	
	

}
