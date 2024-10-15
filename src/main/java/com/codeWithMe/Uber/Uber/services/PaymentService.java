package com.codeWithMe.Uber.Uber.services;

import com.codeWithMe.Uber.Uber.entities.Payment;
import com.codeWithMe.Uber.Uber.entities.Ride;
import com.codeWithMe.Uber.Uber.entities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus status);

}
