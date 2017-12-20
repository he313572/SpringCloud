package com.honpe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
	@GetMapping("/ribbon/{name}")
	public String getRibbon(@PathVariable String name) {
		return "你好" + name + "我是ribbon";
	}
}
