package com.jialin.practice.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplicationMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplicationMain7001.class, args);
    }
}
