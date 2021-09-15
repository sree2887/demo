package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Billionaires;

public interface BillonaireRepository extends CrudRepository<Billionaires, Long>{

	List<Billionaires> findBySalaryLessThan(Integer salary);
	
}
