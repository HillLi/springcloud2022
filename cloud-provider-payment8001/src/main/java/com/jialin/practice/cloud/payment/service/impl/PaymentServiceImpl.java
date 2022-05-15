package com.jialin.practice.cloud.payment.service.impl;

import com.jialin.practice.cloud.payment.entities.Payment;
import com.jialin.practice.cloud.payment.mapper.PaymentMapper;
import com.jialin.practice.cloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;


    @Override
    public int save(Payment payment) {
        return paymentMapper.save(payment);
    }

    @Override
    public int update(Payment payment) {
        return paymentMapper.update(payment);
    }

    @Override
    public void deleteByID(Long id) {
        paymentMapper.deleteByID(id);
    }

    @Override
    public Payment queryById(Long id) {
        return paymentMapper.queryPaymentById(id);
    }
}
