package com.example.demo.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillionairControllerTest {
	
	
	@LocalServerPort 
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	
	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void getAllBillionairesTest() {
		
		HttpEntity entity = new HttpEntity(null, headers);
		
		ResponseEntity response = restTemplate.exchange(createURLWithPort("/usermanager/getAllBillion"), HttpMethod.GET, entity, String.class);
		
		assertNotNull(response);

		
	}
	
	private String createURLWithPort(String uri)
    {
        return "http://localhost:" + port + uri;
    }

}
