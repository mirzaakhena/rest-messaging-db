package com.brainmatics.producer.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brainmatics.producer.model.Product;

@RestController
@RequestMapping("/send")
public class SenderController {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@GetMapping("/hello")
	public String sendHello() {
		Product product = new Product("Baju", 20000);		
		rabbitTemplate.convertAndSend("exchange", "hello", product);	
		return String.format("message from hello : %s ", product);
	}
	
	@GetMapping("/world")
	public String sendWorld() {
		Product product = new Product("Celana", 35000);		
		rabbitTemplate.convertAndSend("exchange", "world", product);	
		return String.format("message from world : %s ", product);
	}
	

}
