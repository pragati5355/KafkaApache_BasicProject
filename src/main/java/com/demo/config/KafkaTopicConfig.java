package com.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@Configurable
public class KafkaTopicConfig {

	@Bean
	public NewTopic demoTopic() {
		return TopicBuilder.name("demo")
				.build();
	}
	
	@Bean
	public NewTopic demoJsonTopic() {
		return TopicBuilder.name("demo_json")
				.build();
	}
}
