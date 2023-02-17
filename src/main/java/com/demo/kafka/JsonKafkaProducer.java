package com.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.demo.model.UserModel;

@Service
public class JsonKafkaProducer {

	private static final Logger LOGGER =  LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	private KafkaTemplate<String, UserModel> kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, UserModel> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(UserModel data) {
		
		LOGGER.info(String.format("Message send -> %s", data.toString()));
		
		Message<UserModel> message = MessageBuilder
				.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC, "demo_json")
				.build();
		
		kafkaTemplate.send(message);
	}
	
}
