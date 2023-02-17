package com.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	// This consumes the Kafka String Messages
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics = "demo", groupId = "myGroup")
	public void consume(String message) {
		
		LOGGER.info(String.format("Message received -> %s", message));
		
	}

}
