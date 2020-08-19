package com.oyo.book.services;

import org.springframework.stereotype.Component;

import com.oyo.book.model.Greeting;

@Component
public interface MessageProducer {
	public void sendMessage(Greeting message);
	public void sendMessageToPartition(Greeting message, int partition);
	public void sendMessageToFiltered(Greeting message);
	public void sendGreetingMessage(Greeting greeting);
}
