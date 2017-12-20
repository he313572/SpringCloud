package com.honpe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.honpe.mq.SinkSender;

@RestController
public class MQController {
	@Autowired
	private SinkSender sinkSender;

	@GetMapping("/send/{message}")
	public String sendMessage(@PathVariable String message) {
		boolean flag = sinkSender.output().send(MessageBuilder.withPayload(message).build());
		if (flag) {
			return "发送成功";
		}
		return "发送失败";
	}
}
