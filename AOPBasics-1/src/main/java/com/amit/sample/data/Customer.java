package com.amit.sample.data;

import java.time.LocalDate;

import org.springframework.stereotype.Component;


@Component
public class Customer {
	
	String name;
	String Id;
	String address;
	int age;
	String bankName;
	
	LocalDate doj;
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public Customer(String name, String id, String address, int age, String bankName, LocalDate doj) {
		super();
		this.name = name;
		Id = id;
		this.address = address;
		this.age = age;
		this.bankName = bankName;
		this.doj = doj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Customer() {
		super();
	}
	public void setData(String name, String id, String address, int age, String bankName, LocalDate doj) throws Exception {
		this.name=name;
		this.Id=id;
		this.address=address;
		this.age=age;
		this.bankName=bankName;
		this.doj=doj;
		
		//throw new Exception("Some exception thrown....");
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", Id=" + Id + ", address=" + address + ", age=" + age + ", bankName="
				+ bankName + ", doj=" + doj + "]";
	
	}
	
	

}
