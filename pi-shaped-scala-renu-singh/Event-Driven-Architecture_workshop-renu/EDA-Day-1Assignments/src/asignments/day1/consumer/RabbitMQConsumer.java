package com.pi.shaped.eda.asignments.day1.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
	
	@RabbitListener(queues = "orders")
	public void recievedMessage(String message) {
		System.out.println("Message Received is : "+ message);
	}

}
