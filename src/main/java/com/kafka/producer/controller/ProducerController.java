package com.kafka.producer.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.api.message.Trade;
import com.kafka.producer.service.IProducerService;
import com.kafka.producer.util.ProducerConstants;

@RestController
@RequestMapping(value = "/fixed-income")
public class ProducerController {

	@Autowired
	private IProducerService service;
	
	@PostMapping(value = ProducerConstants.POST_TRADE, consumes = ProducerConstants.APPLICATION_JSON)
	public String postMessage(
			@RequestBody @NotNull Trade data) {
		return service.publishData(data);
	}
	
}
