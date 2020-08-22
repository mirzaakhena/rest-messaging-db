package com.mirzaakhena.frontend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mirzaakhena.frontend.model.Product;

@RestController
public class FrontendController {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/send-data")
	public ResponseEntity<?> sendData(@RequestParam(defaultValue = "aaa") String name, @RequestParam(defaultValue = "123") double price) {

		Product product = new Product(name, price);
		
		ResponseEntity<String> responseMessage = restTemplate.postForEntity("http://localhost:8081/products", product, String.class);
		
		return ResponseEntity.ok(responseMessage.getBody());
	}
	
	@GetMapping("/get-data")
	public ResponseEntity<?> getData() {

		ResponseEntity<Product[]> productsEntity = restTemplate.getForEntity("http://localhost:8082/products", Product[].class);
		
		List<Product> products = Arrays.asList(productsEntity.getBody());
						
		products.forEach(product -> {
			System.out.println(product);
		});
		
		return ResponseEntity.ok(products);
	}
	
}
