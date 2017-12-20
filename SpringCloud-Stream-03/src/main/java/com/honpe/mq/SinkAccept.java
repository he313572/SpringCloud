package com.honpe.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface SinkAccept {
	String INPUT = "_input";

	@Input(SinkAccept.INPUT)
	MessageChannel messageInput();
}
