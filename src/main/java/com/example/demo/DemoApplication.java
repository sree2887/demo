package com.example.demo;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);ssss
		log.info("Started");
		
		
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   // Do any additional configuration here
	   
		
		
		return builder.build();
	}

}
