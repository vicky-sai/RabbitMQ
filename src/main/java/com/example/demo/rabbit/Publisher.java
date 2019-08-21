package com.example.demo.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.Calendar;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Publisher {

	@Autowired
	RabbitTemplate template;
	
	@Autowired
	Queue queue;
	 
	@Scheduled(fixedDelay = 1000, initialDelay = 100)
	public void send() {
		
		template.convertAndSend(queue.getName(), "======Vegan meals "+Calendar.getInstance().getTimeInMillis()+" Units=======");
		log.info("Annanukku oru uthaapam..!!!");
	}
	

}
