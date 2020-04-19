package com.amit.rest.dao;

import org.springframework.stereotype.Repository;

import com.amit.rest.model.Employee;
import com.amit.rest.model.Employees;

@Repository
public class EmployeeDAO 
{
    private static Employees list = new Employees();
    
    static 
    {
        list.getEmployeeList().add(new Employee(1, "Binod", "Anand", "binod@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Nupur", "Chopra", "nupur@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "Amit", "Sharma", "amit@gmail.com"));
    }
    
    public Employees getAllEmployees() 
    {
        return list;
    }
    
    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}
