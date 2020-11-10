package com.example.demo.repo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable {

	@Id
	int empCode;
	String empName;
	int salary;
	public int getEmpCode() {
		return empCode;
	}
	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(int empCode, String empName, int salary) {
		super();
		this.empCode = empCode;
		this.empName = empName;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	
}
