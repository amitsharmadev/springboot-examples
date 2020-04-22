package com.amit.sample;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallerController {
	
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	
	@RequestMapping("/call/{applicationName}")
	public String serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		
		ServiceInstance si=loadBalancerClient.choose(applicationName);
		
		String baseUri=si.getUri().toString();
		baseUri+="/demo";
		RestTemplate rt=new RestTemplate();
		ResponseEntity<String> response=null;
		try {
			response=rt.exchange(baseUri, HttpMethod.GET, getHeaders(), String.class);
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response.getBody();
	
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
