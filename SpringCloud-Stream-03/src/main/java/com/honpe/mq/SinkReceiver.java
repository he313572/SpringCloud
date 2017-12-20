package com.honpe.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

@EnableBinding(value = { Sink.class, SinkAccept.class })
public class SinkReceiver {
	private static final Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

	// rabbitmq 原生注解的支持
	@ServiceActivator(inputChannel = Sink.INPUT)
	public void receiver(Object payload) {
		logger.info("receiverId:" + payload);
	}

	@ServiceActivator(inputChannel = SinkAccept.INPUT)
	public void getQueues(Object msg) {
		System.out.println("stream-02:" + msg);
	}
}
