package com.amit.sample;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;


@RestController
public class DemoController {

	
	@RequestMapping("/person/{name}/{code}")
	public Person getPerson(@PathVariable("name") String name,
					@PathVariable ("code") String code) {
		Person p=new Person();
		p.setName(name);
		p.setId(code);
		//p.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(DemoController.class))
		//		.withSelfRel());
		p.add(linkTo(methodOn(DemoController.class).getPerson(name, code)).withSelfRel());
		return p;
	}
	
}
