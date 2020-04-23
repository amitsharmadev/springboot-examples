package com.amit.sample;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Employee {

	String name;
	@Id
	String code;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Employee(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}
	public Employee() {
		super();
	}
	
	public Employee setResponse(String data) {
		this.name=data;	
		this.code="101";
		return this;
	}
}
