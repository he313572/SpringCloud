package com.honpe.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

public interface SinkSender {
	String MSG_ = "input_msg";

	// 绑定input消息通道
	@Output(SinkSender.MSG_)
	MessageChannel output();
}
