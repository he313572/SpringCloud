package com.honpe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/*
 * @EnableTurbine接口激活对Turbine的支持
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class TurbineApp {
	public static void main(String[] args) {
		SpringApplication.run(TurbineApp.class, args);
	}
}
