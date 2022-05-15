package com.jialin.practice.cloud.payment.mapper;

import com.jialin.practice.cloud.payment.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    int save(Payment payment);

    Payment queryPaymentById(@Param("id") Long id);

    int deleteByID(@Param("id") Long id);

    int update(Payment payment);
}
