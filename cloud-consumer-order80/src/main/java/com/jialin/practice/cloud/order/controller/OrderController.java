package com.jialin.practice.cloud.order.controller;

import com.jialin.practice.cloud.order.entities.CommonResult;
import com.jialin.practice.cloud.order.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class OrderController {

    private static final String PAYMENT_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/save")
    public CommonResult<Payment> save(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, CommonResult.class);
    }

    @GetMapping("/payment/query/{id}")
    public CommonResult<Payment> queryById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/query/" + id, CommonResult.class);
    }


    @GetMapping("/payment/delete/{id}")
    public CommonResult<Payment> deleteById(@PathVariable("id") Long id) {
        restTemplate.delete(PAYMENT_URL + "/payment/delete/" + id);
        return CommonResult.SUCCESS();
    }

    @GetMapping("/payment/update")
    public CommonResult<Payment> deleteById(Payment payment) {
        restTemplate.put(PAYMENT_URL + "/payment/update/", payment);
        return CommonResult.SUCCESS();
    }

}
