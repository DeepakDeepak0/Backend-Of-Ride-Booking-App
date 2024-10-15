package com.codeWithMe.Uber.Uber.strategies;

import com.codeWithMe.Uber.Uber.entities.Payment;

public interface PaymentStrategy {

    Double PLATFORM_COMMISSION = 0.3;
    void processPayment(Payment payment);

}
