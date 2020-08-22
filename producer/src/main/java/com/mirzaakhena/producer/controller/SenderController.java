package com.mirzaakhena.producer.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mirzaakhena.producer.model.Product;

@RestController
public class SenderController {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@PostMapping("/products")
	public String publishProduct(@RequestBody Product product) {
		rabbitTemplate.convertAndSend("exchange", "product_event", product);
		return String.format("message from product_event : %s ", product);
	}
	
	@GetMapping("/hello")
	public String publishHello() {
		String message = "Hello World";
		rabbitTemplate.convertAndSend("exchange", "hello_event", message);
		return String.format("message from hello_event : %s ", message);
	}	

}
