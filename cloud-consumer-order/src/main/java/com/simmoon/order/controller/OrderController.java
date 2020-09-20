package com.simmoon.order.controller;

import com.simmoon.commons.entites.CommonResult;
import com.simmoon.commons.entites.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
//    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.patchForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getPayment")
    public CommonResult<Payment> getPayment(@PathParam("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPayment/" + id, CommonResult.class);
    }


}
