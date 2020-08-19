package com.oyo.book.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.oyo.book.stream.StreamProducer;

@EnableBinding(StreamProducer.class)
public class StreamsConfig {

}
