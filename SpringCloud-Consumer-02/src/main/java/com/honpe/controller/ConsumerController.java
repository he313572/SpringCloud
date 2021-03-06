package com.honpe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.honpe.remote.HelloRemote;

@RestController
public class ConsumerController {
	@Autowired
	private HelloRemote helloRemote;

	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return helloRemote.hello(name);
	}
}
