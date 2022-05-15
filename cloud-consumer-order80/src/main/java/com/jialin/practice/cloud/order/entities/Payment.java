package com.jialin.practice.cloud.order.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;
    private String serial;
}
