package com.brainmatics.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FrontendController {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/send-data")
	public ResponseEntity<?> sendData() {

		restTemplate.getForEntity("http://localhost:8080/send/hello", String.class);
		
		return ResponseEntity.ok("Data terkirim");
	}
	
}
