package com.honpe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.honpe.filter.AccessFilter;

@SpringBootApplication
@EnableZuulProxy
public class GatewayServiceApp {
	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApp.class, args);
	}
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
}
