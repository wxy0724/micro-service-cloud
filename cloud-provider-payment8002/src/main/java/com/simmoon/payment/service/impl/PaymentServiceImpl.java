package com.simmoon.payment.service.impl;

import com.simmoon.commons.entites.Payment;
import com.simmoon.payment.dao.PaymentMapper;
import com.simmoon.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentMapper paymentMapper;

    @Override
    public Integer addPayment(Payment payment) {
        return paymentMapper.addPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }

}
