package com.oyo.book.services;


import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.oyo.book.model.Greeting;
import com.oyo.book.stream.StreamProducer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StreamMessageProducerImpl implements StreamMessageProducer{
	
	private final StreamProducer streamProducer;
	
	public StreamMessageProducerImpl(StreamProducer streamProducer) {
		this.streamProducer = streamProducer;
	}

	@Override
	public void sendMessage(final Greeting message) {
		log.info("Sending message :" + message);
		MessageChannel messageChannel = streamProducer.publishRequest();
		
		messageChannel.send(MessageBuilder.withPayload(message)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
		
	}

}