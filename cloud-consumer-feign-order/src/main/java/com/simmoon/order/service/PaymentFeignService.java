package com.simmoon.order.service;

import com.simmoon.commons.entites.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/getPayment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

}
