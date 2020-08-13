package com.brainmatics.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	@Bean
	public DirectExchange exchange() {
		return new DirectExchange("exchange");
	}

	@Bean
	public Queue queueHello() {
		return new Queue("hello");
	}

	@Bean
	public Queue queueWorld() {
		return new Queue("world");
	}

	@Bean
	public Binding bindingHello() {
		return BindingBuilder.bind(queueHello()).to(exchange()).withQueueName();
	}
	
	@Bean
	public Binding bindingWorld() {
		return BindingBuilder.bind(queueWorld()).to(exchange()).withQueueName();
	}
	
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory rabbitConnectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(rabbitConnectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter());
		return rabbitTemplate;
	}
	
}
