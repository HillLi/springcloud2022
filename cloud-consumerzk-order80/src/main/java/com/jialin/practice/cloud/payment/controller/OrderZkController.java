package com.jialin.practice.cloud.payment.controller;

import com.jialin.practice.cloud.common.entities.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/orderzk")
public class OrderZkController {

    private static Logger logger = LoggerFactory.getLogger(OrderZkController.class);

    private static String CLOUD_PROVIDER_PAYMENT_URL = "http://cloud-payment-service";

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/info")
    public CommonResult queryInfo() {
        return restTemplate.getForObject(CLOUD_PROVIDER_PAYMENT_URL + "/payment/zk/info", CommonResult.class);
    }
}
