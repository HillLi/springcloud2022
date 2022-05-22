package com.jialin.practice.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkApplicationMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderZkApplicationMain80.class, args);
    }
}
