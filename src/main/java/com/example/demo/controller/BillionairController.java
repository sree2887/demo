package com.example.demo.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Billionaires;
import com.example.demo.repository.BillonaireRepository;

@RestController
@RequestMapping("/")
public class BillionairController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	BillonaireRepository billionaireRepo;

	@GetMapping(value = "getAllBillion")
	public ResponseEntity<List<Billionaires>> getAllBillionaires(){
		List<Billionaires> billion = (List<Billionaires>) billionaireRepo.findAll();
		return new ResponseEntity<List<Billionaires>>(billion, HttpStatus.OK);
	}
	
	@GetMapping(value = "getBillionById/{id}")
	public Billionaires getABillionById(@PathVariable(value="id") Long id){
		Optional<Billionaires> guy = billionaireRepo.findById(id);
		return guy.orElseThrow();
	}
	
	@PostMapping(value = "/saveBillionaire")
	public ResponseEntity<Billionaires> saveBillioanire(@RequestBody Billionaires theGuy){
		Billionaires billion = billionaireRepo.save(theGuy);   
		if(Objects.nonNull(billion)) {
			return new ResponseEntity<Billionaires>(billion, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Billionaires>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/smallGuy/{salary}")
	public ResponseEntity<List<Billionaires>> getSmallBillionaires(@PathVariable(value = "salary") Integer salary){
		List<Billionaires> small = (List<Billionaires>) billionaireRepo.findBySalaryLessThan(salary);
		return new ResponseEntity<List<Billionaires>>(small, HttpStatus.OK);
	}
	
	@GetMapping("api/")
	public ResponseEntity<String>getUsers(){
		String response = restTemplate.getForObject("https://reqres.in/api/users?page=21", String.class);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
