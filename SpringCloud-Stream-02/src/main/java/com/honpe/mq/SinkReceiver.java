package com.honpe.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(value = { Sink.class, SinkAccept.class })
public class SinkReceiver {
	private static final Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

	@StreamListener(Sink.INPUT)
	public void receiver(Object payload) {
		logger.info("receiverId:" + payload);
	}

	@StreamListener(SinkAccept._MSG)
	public void mqMessage(Object msg) {
		System.out.println("message：" + msg);
	}
}
