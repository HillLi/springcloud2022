package com.jialin.practice.cloud.payment.controller;

import com.jialin.practice.cloud.common.entities.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private static Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zk/info")
    public CommonResult queryInfo() {
        return CommonResult.SUCCESS("QUEYR ZOOKEEPER INFO SUCCESS," + UUID.randomUUID().toString());
    }
}
