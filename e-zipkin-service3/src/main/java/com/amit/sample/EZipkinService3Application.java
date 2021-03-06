package com.amit.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.ProbabilityBasedSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@SpringBootApplication
public class EZipkinService3Application {

	public static void main(String[] args) {
		SpringApplication.run(EZipkinService3Application.class, args);
	}

}

@RestController
class ZipkinController{
	
	@Autowired
	RestTemplate restTemplate;
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}@Bean
	public Sampler alwaysSampler() {
		return ProbabilityBasedSampler.ALWAYS_SAMPLE;
	}
	private static final Logger LOG = Logger.getLogger(ZipkinController.class.getName());
	
	@GetMapping(value="/zipkin3")
	public String zipkinService1() {
		LOG.info("Inside zipkinService 3..");
		String response = (String) restTemplate.exchange("http://localhost:8084/zipkin4", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }).getBody();
		return "Hi...";
	}
}
