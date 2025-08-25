package com.pi.shaped.eda.asignments.day1.service;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pi.shaped.eda.asignments.day1.producer.RabbitMQProducer;

@Component
public class EventService {
	
	@Autowired
	private RabbitMQProducer rabbitMQProducer;
	
	public Map processOrder(final Map<String, String> requestedPayload) {
		System.out.println("Process Message : " + requestedPayload);
		requestedPayload.put("orderId", UUID.randomUUID().toString());
		requestedPayload.put("status", "placed");
		rabbitMQProducer.sendMessage(requestedPayload.toString());
		return requestedPayload;
	}

}
