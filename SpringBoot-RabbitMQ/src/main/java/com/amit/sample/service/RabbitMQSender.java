package com.amit.sample.service;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amit.sample.domain.Employee;


@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${demo.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${demo.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(Employee emp) {
		rabbitTemplate.convertAndSend(exchange, routingkey, emp);
		System.out.println("Send msg = " + emp);
	    
	}
}