package com.honpe.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.honpe.remote.HelloRemote;
/*
 * 熔断器
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {

	@Override
	public String hello(@RequestParam(value = "name") String name) {
		// TODO Auto-generated method stub
		return "您好！ " + name + " 服务调用异常";
	}

}
