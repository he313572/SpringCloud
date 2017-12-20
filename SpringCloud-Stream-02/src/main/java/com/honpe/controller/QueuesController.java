package com.honpe.controller;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueuesController {
	@Qualifier("output")
	private MessageChannel messageChannel;

	@GetMapping("/send/{msg}")
	public String send(@PathVariable String msg) {
		GenericMessage<String> genericMessage = new GenericMessage<String>(msg);
		boolean send = messageChannel.send(genericMessage);
		if (send) {
			return "发送成功";
		}
		return "发送失败";
	}
}
