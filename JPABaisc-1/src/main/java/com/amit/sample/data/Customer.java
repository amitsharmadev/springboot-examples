package com.amit.sample.data;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@NamedQuery(name = "Customer.fetchByAddress",
			query = "SELECT c FROM Customer c WHERE c.address =:address")
@Component
@Entity
@Table(name = "Customer")
@SecondaryTable(name = "pool", pkJoinColumns = @PrimaryKeyJoinColumn())
public class Customer {
	
	String name;
	@javax.persistence.Id
	String Id;
	String address;
	int age;
	String bankName;
	
	@Column(name = "date_join")
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
	@Override
	public String toString() {
		return "Customer [name=" + name + ", Id=" + Id + ", address=" + address + ", age=" + age + ", bankName="
				+ bankName + ", doj=" + doj + "]";
	
	}
	
	

}
