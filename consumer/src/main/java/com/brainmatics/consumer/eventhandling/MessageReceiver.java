package com.brainmatics.consumer.eventhandling;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainmatics.consumer.model.Product;
import com.brainmatics.consumer.repository.ProductRepo;


@Service
public class MessageReceiver {
	
	@Autowired
	private ProductRepo productRepo;

	@RabbitListener(queues = "hello")
	public void onReceiveHello(Product product) {		
		System.out.println(">> hello >> "+ product);
		
		productRepo.save(product);
		
	}
	
	@RabbitListener(queues = "world")
	public void onReceiveWorld(Product product) {		
		System.out.println(">> world >> "+ product);		
	}
	
}
