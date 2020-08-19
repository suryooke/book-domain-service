package com.oyo.book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.oyo.book.model.Greeting;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageProducerImpl implements MessageProducer{
	
	@Autowired
	private KafkaTemplate<String, Greeting> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String, Greeting> greetingKafkaTemplate;
	
	@Value(value = "${message.topic.name}")
    private String topicName;

    @Value(value = "${partitioned.topic.name}")
    private String partitionedTopicName;

    @Value(value = "${filtered.topic.name}")
    private String filteredTopicName;

    @Value(value = "${greeting.topic.name}")
    private String greetingTopicName;

    public void sendMessage(Greeting message) {

        ListenableFuture<SendResult<String, Greeting>> future = kafkaTemplate.send(topicName, message);
        log.info("Sending message : " + message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Greeting>>() {

            @Override
            public void onSuccess(SendResult<String, Greeting> result) {
                System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata()
                    .offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });
    }
    
    public void sendMessageToPartition(Greeting message, int partition) {
        kafkaTemplate.send(partitionedTopicName, partition, null, message);
    }

    public void sendMessageToFiltered(Greeting message) {
        kafkaTemplate.send(filteredTopicName, message);
    }

    public void sendGreetingMessage(Greeting greeting) {
        greetingKafkaTemplate.send(greetingTopicName, greeting);
    }
}
