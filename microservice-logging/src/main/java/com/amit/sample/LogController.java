package com.amit.sample;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
public class LogController {


	private static final Logger LOG=Logger.getLogger(LogController.class.getName());
	
	@GetMapping("/data")
	public String doSomething(@RequestParam("name") String name) {
		LOG.info("Request Param :"+name);
		return name +" - " +new Date();
	}
	
	@GetMapping("/exception")
	public void throwException() {
		try {
		throw new Exception();
		}
		catch (Exception e) {
			LOG.log(Level.SEVERE, "Exception "+e);
		}
	}
}
