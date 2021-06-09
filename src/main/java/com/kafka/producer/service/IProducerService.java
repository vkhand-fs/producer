package com.kafka.producer.service;

import org.springframework.stereotype.Component;

import com.kafka.api.message.Trade;

@Component
public interface IProducerService {
	public String publishData(Trade data);
}
