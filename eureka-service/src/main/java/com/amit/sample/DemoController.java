package com.amit.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@Value("${config.server.prop-key}")
	String propVal;
	
	@Value("${config.server.new-key}")
	String newVal;
	
	@GetMapping
	public String fetchData() {
		return propVal +" and " +newVal;
	}
}
