package com.amit.sample;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "sample-service"	)
public interface UserServiceFeign {

	@GetMapping("/users/")
	List<User> getUsers();
	@GetMapping("/users/{id}")
	User getUser(@PathVariable Integer id);
	@PostMapping("/users/")
	void saveUser(@RequestBody User u);
}
