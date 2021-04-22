package com.amit.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amit.sample.domain.User;
import com.amit.sample.repo.UserRepository;

@RestController()
@RefreshScope
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Value("${sample.prop}")
	String data;
	
	@GetMapping("/demo")
	public String getDemo() 
			throws InterruptedException 
	{
		//Thread.sleep(10000);
		return "Data from E-Service: "+ data;
	}
	
	@GetMapping("/users/")
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/users/")
	public void saveUser(@RequestBody User u) {
		System.out.println("**************Coming***************8");
		userRepository.save(u);
	}
	
	
	@GetMapping("/users/{id}/")
	public User getUser(@PathVariable Integer id) {
		return userRepository.findById(id).get();
	}
	
	
}
