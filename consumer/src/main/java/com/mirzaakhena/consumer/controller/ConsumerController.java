package com.mirzaakhena.consumer.controller;

import com.mirzaakhena.consumer.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConsumerController {

	@Autowired
	private ProductRepo productRepo;
	
	@GetMapping("/products")
	public ResponseEntity<?> getAllProductFromDB() {		
		
		// get all data product from database and return it as list
		return ResponseEntity.ok(productRepo.findAll()); 
	}
	
}
