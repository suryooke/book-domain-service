package com.oyo.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oyo.book.model.Greeting;
import com.oyo.book.services.MessageProducerImpl;

@RestController
@RequestMapping("/api/v1")
public class GreetingController {

	@Autowired
	private MessageProducerImpl messageProducer;
	
	@PostMapping("/greeting/{message}")
	public Greeting putNewMessage(@PathVariable(value = "message") String message) {
		System.out.println("Receive message : " + message);
		Greeting greet = new Greeting();
		greet.setMsg(message);
		greet.setName("test");
		messageProducer.sendMessage(message);
		return greet;
	}
	
}
