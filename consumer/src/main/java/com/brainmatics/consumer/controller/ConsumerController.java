package com.brainmatics.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brainmatics.consumer.repository.ProductRepo;

@RestController
public class ConsumerController {

	@Autowired
	private ProductRepo productRepo;
	
	@GetMapping("/products")
	public ResponseEntity<?> getAllProductFromDB() {			
		return ResponseEntity.ok(productRepo.findAll()); 
	}
	
}
