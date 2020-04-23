package com.amit.sample;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

	
	@Autowired
	EmployeeService empService;
	
	@Value("${config.server.prop-key}")
	String propVal;
	
	@Value("${config.server.new-key}")
	String newVal;
	
	@GetMapping
	public String fetchData() {
		return propVal +" and " +newVal;
	}
	
	@PostMapping
	public void saveData(@RequestBody Employee emp) {
		IntStream.range(1, 100).forEach(a->{
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			empService.saveEmployee(emp);
		});
	}
	
}
