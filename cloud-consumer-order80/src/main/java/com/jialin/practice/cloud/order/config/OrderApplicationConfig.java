package com.jialin.practice.cloud.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderApplicationConfig {

    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }

}