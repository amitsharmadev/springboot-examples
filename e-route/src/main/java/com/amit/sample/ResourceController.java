package com.amit.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ResourceController {
	
	@Autowired
	private UserServiceFeign userServiceFeign;
		
	
	@GetMapping("/users/")
	List<User> getUsers(){
		return userServiceFeign.getUsers();
	}
	@GetMapping("/users/{id}")
	User getUser(@PathVariable Integer id) {
		return userServiceFeign.getUser(id);
	}
	@PostMapping("/users")
	void saveUser(@RequestBody User u) {
		System.out.println("##################### Data ##################### "+u.name+u.id+u.age);
		userServiceFeign.saveUser(u);
		
	}
	

}
