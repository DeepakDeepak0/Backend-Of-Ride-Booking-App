package com.codeWithMe.Uber.Uber.strategies.Impl;

import com.codeWithMe.Uber.Uber.entities.Driver;
import com.codeWithMe.Uber.Uber.entities.Payment;
import com.codeWithMe.Uber.Uber.entities.enums.PaymentStatus;
import com.codeWithMe.Uber.Uber.entities.enums.TransactionMethod;
import com.codeWithMe.Uber.Uber.repositories.PaymentRepository;
import com.codeWithMe.Uber.Uber.services.PaymentService;
import com.codeWithMe.Uber.Uber.services.WalletService;
import com.codeWithMe.Uber.Uber.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//Rider ->100
//Driver -> 100 deduct 30rs from Driver's wallet

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {

        Driver driver = payment.getRide().getDriver();

        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;

        walletService.deductMoneyFromWallet(driver.getUser(), platformCommission,
                null,payment.getRide(), TransactionMethod.RIDE);

            payment.setPaymentStatus(PaymentStatus.CONFIRMED);
            paymentRepository.save(payment);
    }
}
