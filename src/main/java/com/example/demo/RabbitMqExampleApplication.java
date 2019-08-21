package com.example.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.rabbit.Publisher;
import com.example.demo.rabbit.Subscriber;


@SpringBootApplication
public class RabbitMqExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(RabbitMqExampleApplication.class, args);
		
		Publisher publisher = ctx.getBean(Publisher.class);
		publisher.send();
		
		//Subscriber sub = ctx.getBean(Subscriber.class);
		//sub.receive();
		
	}

	@Bean
	public Queue queue() {
		
		return new Queue("Spice-Jet-Orders");
	}
	
//	@Bean
	public RabbitTemplate template() {
		return new RabbitTemplate();
	}
	
	@Bean
	public Publisher publisher() {
		
		return new Publisher();
	}
	
	@Bean
	public Subscriber subscriber() {
		
		return new Subscriber();
	}
}
