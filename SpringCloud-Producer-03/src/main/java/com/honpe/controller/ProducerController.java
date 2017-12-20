package com.honpe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
	@RequestMapping("hello")
	public String hello(@RequestParam String name) {
		return "你好！ " + name + " 这是第二(7003)个服务";
	}
}
