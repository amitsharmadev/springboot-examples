package com.amit.sample;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class Person extends RepresentationModel<Person> {

	
	String name;
	String Id;
	public String getName() {
		return name;
	}
	@JsonCreator
	public void setName(@JsonProperty String name) {
		this.name = name;
	}
	public String getId() {
		return Id;
	}
	@JsonCreator
	public void setId(@JsonProperty String id) {
		Id = id;
	}
	public Person(String name, String id) {
		super();
		this.name = name;
		Id = id;
	}
	public Person() {
		super();
	}
	
	
}
