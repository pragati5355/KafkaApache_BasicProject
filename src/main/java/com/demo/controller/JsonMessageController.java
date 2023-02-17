package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kafka.JsonKafkaProducer;
import com.demo.model.UserModel;

@RestController
@RequestMapping("/api/kafka")
public class JsonMessageController {

	@Autowired
	private JsonKafkaProducer jsonKafkaProducer;
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody UserModel model) {
		
		jsonKafkaProducer.sendMessage(model);
		return ResponseEntity.ok("Json Message send to kafka Topic");
		
		
	}
	
}
