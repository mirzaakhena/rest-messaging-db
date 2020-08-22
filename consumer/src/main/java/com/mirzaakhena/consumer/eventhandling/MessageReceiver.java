package com.mirzaakhena.consumer.eventhandling;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirzaakhena.consumer.model.Product;
import com.mirzaakhena.consumer.repository.ProductRepo;

@Service
public class MessageReceiver {

	@Autowired
	private ProductRepo productRepo;

	@RabbitListener(queues = "product_event")
	public void onReceiveProduct(Product product) {
		System.out.println(">> product_event >> " + product);

		productRepo.save(product);
	}

	@RabbitListener(queues = "hello_event")
	public void onReceiveHello(String message) {
		System.out.println(">> hello_event >> " + message);
	}

}
