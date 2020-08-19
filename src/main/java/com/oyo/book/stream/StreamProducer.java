package com.oyo.book.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamProducer {
	String INPUT = "greet-in";
    String OUTPUT = "greet-out";
    
	@Input(INPUT)
    SubscribableChannel inboundGreetings();
	
	@Output(OUTPUT)
	MessageChannel publishRequest();

}
