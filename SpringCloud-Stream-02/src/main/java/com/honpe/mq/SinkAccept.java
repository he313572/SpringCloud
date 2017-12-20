package com.honpe.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface SinkAccept {
	String _MSG = "input_msg";

	@Input(SinkAccept._MSG)
	MessageChannel input();
}
