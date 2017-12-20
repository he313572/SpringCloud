package com.honpe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfReadController {
	@Value("${neo.hello}")
	private String hello;

	@RequestMapping("get")
	public String getHello() {
		return hello;
	}
}
