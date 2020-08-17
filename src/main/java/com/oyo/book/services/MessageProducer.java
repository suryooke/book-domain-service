package com.oyo.book.services;

import com.oyo.book.model.Greeting;

public interface MessageProducer {
	public void sendMessage(String message);
	public void sendMessageToPartition(String message, int partition);
	public void sendMessageToFiltered(String message);
	public void sendGreetingMessage(Greeting greeting);
}
