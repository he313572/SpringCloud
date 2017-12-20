package com.honpe.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.honpe.hystrix.HelloRemoteHystrix;
/*
 * 远程服务调用
 */
@FeignClient(name = "spring-cloud-producer-02",fallback=HelloRemoteHystrix.class)
public interface HelloRemote {
	@RequestMapping("hello")
	String hello(@RequestParam(value = "name") String name);
}
