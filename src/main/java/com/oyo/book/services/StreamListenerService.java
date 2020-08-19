package com.oyo.book.services;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.oyo.book.model.Greeting;
import com.oyo.book.stream.StreamProducer;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StreamListenerService {
	
	@StreamListener(StreamProducer.INPUT)
	public void handleGreetings(@Payload Greeting greeting) {
		log.info("Received greeting : {}", greeting);
	}

}
