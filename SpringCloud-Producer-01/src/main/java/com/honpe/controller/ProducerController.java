package com.honpe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
	@RequestMapping("hello")
	public String hello(@RequestParam String name) {
		return "hello！ " + name + " 这是第一个服务";
	}
}
