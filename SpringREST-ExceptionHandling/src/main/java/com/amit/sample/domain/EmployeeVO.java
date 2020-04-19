package com.amit.sample.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
//@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorType()
//public class EmployeeVO extends ResourceSupport implements Serializable
@Entity
public class EmployeeVO implements Serializable
{
	@Id
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
 
    public EmployeeVO(Integer id, String firstName, String lastName, String email) {
        super();
        this.employeeId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
 
    public EmployeeVO() {
    }

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
     
    //Removed setter/getter for readability
}