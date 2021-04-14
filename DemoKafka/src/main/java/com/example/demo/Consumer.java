	package com.example.demo;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
	public class Consumer {

	    private final Logger logger = LoggerFactory.getLogger(Producer.class);

	    @KafkaListener(topics = "products", groupId = "mygroup_id")
	    public void consume(String message) throws IOException {
	        logger.info(String.format("#### -> Consumed message -> %s", message));
	    }
	}