package com.honpe.mq;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import ch.qos.logback.core.joran.action.NestedBasicPropertyIA;

/*
 * rabbitmq 原生支持
 * 发送消息
 */
@EnableBinding(value = SinkSender.SinkOutput.class)
public class SinkSender {

	@Bean
	@InboundChannelAdapter(value = SinkOutput.OUTPUT, poller = @Poller(fixedDelay = "10000"))
	public MessageSource timeMessageSource() {
		return () -> new GenericMessage<>(new Date());
	}

	// 消息格式转换
	@Transformer(outputChannel = SinkOutput.OUTPUT, inputChannel = SinkOutput.OUTPUT)
	public Object transform(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
	}

	public interface SinkOutput {
		String OUTPUT = "_input";

		@Output(SinkOutput.OUTPUT)
		MessageChannel output();
	}
}
