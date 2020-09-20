package com.simmoon.payment.controller;

import com.simmoon.commons.entites.CommonResult;
import com.simmoon.commons.entites.Payment;
import com.simmoon.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@EnableDiscoveryClient
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult addPayment(@RequestBody Payment payment) {
        Integer result = paymentService.addPayment(payment);
        if (result > 0) {
            return new CommonResult(200, "success" + serverPort, result);
        } else {
            return new CommonResult(500, "fail", null);
        }
    }

    @GetMapping(value = "/payment/getPayment/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById != null) {
            return new CommonResult(200, "success" + serverPort, paymentById);
        } else {
            return new CommonResult(500, "fail", null);
        }

    }

    @GetMapping(value = "/payment/discovery")
    Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }


}
