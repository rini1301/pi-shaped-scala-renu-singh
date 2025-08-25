package com.pi.shaped.eda.asignments.day1.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi.shaped.eda.asignments.day1.service.EventService;

@RestController
@RequestMapping("api/v1")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@PostMapping("/order/placed")
	public Map submitOrderPlaced(@RequestBody Map<String, String> requestPayload) {
		
		return eventService.processOrder(requestPayload);
	}

}
