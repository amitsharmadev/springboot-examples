package com.amit.sample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amit.sample.domain.Employee;
import com.amit.sample.service.RabbitMQSender;


@RestController
@RequestMapping(value = "/app/")
public class EmployeeController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("empName") String empName,@RequestParam("empId") int empId) {
	
	Employee emp=new Employee();
	emp.setEmpId(empId);
	emp.setName(empName);
		rabbitMQSender.send(emp);

		return "Message sent to the RabbitMQ Successfully";
	}

}