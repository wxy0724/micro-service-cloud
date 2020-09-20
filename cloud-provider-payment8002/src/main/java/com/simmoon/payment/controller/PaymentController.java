package com.simmoon.payment.controller;

import com.simmoon.commons.entites.CommonResult;
import com.simmoon.commons.entites.Payment;
import com.simmoon.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

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


}
