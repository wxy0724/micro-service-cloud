package com.simmoon.order.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfoOk(Integer id) {
        return "------------PaymentFallbackService fall back paymentInfoOk()";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "------------PaymentFallbackService fall back paymentInfoTimeOut()";
    }

    @Override
    public String paymentCircuitBreaker(Integer id) {
        return "------------PaymentFallbackService fall back paymentCircuitBreaker()";
    }

}
