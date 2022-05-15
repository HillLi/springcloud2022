package com.jialin.practice.cloud.payment.service;


import com.jialin.practice.cloud.common.entities.Payment;

public interface PaymentService {

    int save(Payment payment);

    int update(Payment payment);

    void deleteByID(Long id);

    Payment queryById(Long id);

}
