package com.amit.sample;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@JmsListener(destination = "sample.queue")
	public void receiveQueue(String text) {
		System.out.println("In Consumer.......");
		System.out.println(text);
	}

}