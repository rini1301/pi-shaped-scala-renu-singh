package com.pi.shaped.eda.asignments.day1.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {

	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String message) {
		System.out.println("Message Sending to rabbitMQ on the routing key : order.placed via orderEvents exchange");
		try {
			rabbitTemplate.convertAndSend("orderEvents", "order.placed", message);
		}
		catch (Exception e) {
			System.out.println("Exception caught while sending the message to rabbitMQ :"+e);
		}
		
		System.out.println("Order places and posted to orders Queue");
	}
}
