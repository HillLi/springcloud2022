package com.jialin.practice.cloud.payment.controller;

import com.jialin.practice.cloud.common.entities.CommonResult;
import com.jialin.practice.cloud.common.entities.Payment;
import com.jialin.practice.cloud.payment.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private static Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;


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

    @GetMapping("/discovery")
    public CommonResult discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(service -> {
            logger.info("service:{}", service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            instances.forEach(serviceInstance -> {
                logger.info(serviceInstance.getHost() + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getInstanceId() + "\t" + serviceInstance.getServiceId() + "\t" + serviceInstance.getScheme() + "\t" + serviceInstance.getUri() + "\t" + serviceInstance.getMetadata())
                ;
            });
        });

        logger.info("discivery_description:{}", discoveryClient.description());

        return CommonResult.SUCCESS(discoveryClient);
    }
}
