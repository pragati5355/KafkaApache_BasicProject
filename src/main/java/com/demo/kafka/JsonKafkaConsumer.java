package com.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.model.UserModel;

@Service
public class JsonKafkaConsumer {

	private static final Logger LOGGER =  LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics = "demo_json" , groupId = "myGroup")
	public void consume(UserModel model) {
		
		LOGGER.info(String.format("Json Message received -> %s", model.toString()));
		
	}
	
}
