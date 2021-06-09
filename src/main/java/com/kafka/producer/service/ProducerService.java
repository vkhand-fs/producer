package com.kafka.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.api.message.Trade;

@Service
public class ProducerService implements IProducerService {

	@Autowired
	private KafkaTemplate<String, Object> jsonKafkaTemplate;
	
	@Value("${fixedincome.trades.topic}")
	private String topic;
	
	private static final String SUCCESS = "User data published successfully";
	
	@Override
	public String publishData(Trade data) {
		jsonKafkaTemplate.send(topic, data);
		return SUCCESS;
	}

}
