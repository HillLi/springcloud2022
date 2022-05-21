package com.jialin.practice.cloud.payment.controller;

import com.jialin.practice.cloud.common.entities.CommonResult;
import com.jialin.practice.cloud.common.entities.Payment;
import com.jialin.practice.cloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/save")
    public CommonResult save(@RequestBody Payment payment) {
        int save = paymentService.save(payment);
        return save > 0 ? CommonResult.SUCCESS("保存数据成功,服务端口：" + serverPort, save) : CommonResult.ERROR("保存数据失败");
    }

    @GetMapping("/query/{id}")
    public CommonResult queryByID(@PathVariable("id") Long id) {
        return CommonResult.SUCCESS("查询数据成功,服务端口：" + serverPort, paymentService.queryById(id));
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult deleteByID(@PathVariable Long id) {
        paymentService.deleteByID(id);
        return CommonResult.SUCCESS("删除数据成功,服务端口：" + serverPort);
    }

    @PutMapping("update")
    public CommonResult updateById(@RequestBody Payment payment) {
        int update = paymentService.update(payment);
        return update > 0 ? CommonResult.SUCCESS("更新数据成功,服务端口：" + serverPort, update) : CommonResult.ERROR("更新数据失败");
    }
}
