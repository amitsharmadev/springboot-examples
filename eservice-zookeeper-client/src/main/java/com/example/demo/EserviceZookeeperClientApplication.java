package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class EserviceZookeeperClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EserviceZookeeperClientApplication.class, args);
	}

}

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
class FeignClientDemo {

	@Autowired
	private TheClient theClient;

	public String callData() {
		return theClient.getData();
	}
}

@org.springframework.cloud.openfeign.FeignClient(name = "myzookeeper-service")
interface TheClient {

	@RequestMapping(path = "/data", method = RequestMethod.GET)
	@ResponseBody
	String getData();
}


@RestController
 class DemoController {
 
    @Autowired
    private FeignClientDemo feignClientDemo;
 
    @GetMapping("/call-data")
    public String callData() {
        return feignClientDemo.callData();
    }
}