package com.amit.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.amit.sample.config.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class SpringRestUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestUploadApplication.class, args);
	}

}
