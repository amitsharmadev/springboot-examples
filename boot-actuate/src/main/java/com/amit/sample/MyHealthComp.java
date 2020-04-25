package com.amit.sample;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealthComp implements HealthIndicator {

	@Override
	public Health health() {
		// TODO Auto-generated method stub
		
		
		return Health.up().status(Status.OUT_OF_SERVICE).build();
	}

}
