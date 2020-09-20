package com.simmoon.payment.service;

import com.simmoon.commons.entites.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    Integer addPayment(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
