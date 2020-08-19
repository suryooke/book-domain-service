package com.oyo.book.services;

import com.oyo.book.model.Greeting;

public interface StreamMessageProducer {
	
	public void sendMessage(Greeting message);

}
