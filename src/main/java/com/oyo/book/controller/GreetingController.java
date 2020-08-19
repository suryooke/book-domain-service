package com.oyo.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oyo.book.model.DefaultResponse;
import com.oyo.book.model.Greeting;
import com.oyo.book.services.MessageProducer;
import com.oyo.book.services.StreamMessageProducer;

@RestController
@RequestMapping("/api/v1")
public class GreetingController {

	@Autowired
	private MessageProducer messageProducer;
	
	@Autowired
	private StreamMessageProducer smp;
	
	@PostMapping("/greeting/{message}")
	public Greeting putNewMessage(@PathVariable(value = "message") String message) {
		System.out.println("Receive message : " + message);
		Greeting greet = new Greeting();
		greet.setMsg(message);
		greet.setName("Offset");
		messageProducer.sendMessage(greet);
		return greet;
	}
	
	@GetMapping("/greetings/stream/{message}")
	public DefaultResponse putNewMessageStream(@PathVariable(value = "message") String message) {
		
		Greeting msg = new Greeting(message);
		
		smp.sendMessage(msg);
		
		DefaultResponse res = new DefaultResponse(message);
		
		return res;
		
	}
	
	
}
