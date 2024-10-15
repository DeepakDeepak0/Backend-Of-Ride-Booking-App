package com.codeWithMe.Uber.Uber.strategies.Impl;

import com.codeWithMe.Uber.Uber.entities.Driver;
import com.codeWithMe.Uber.Uber.entities.Payment;
import com.codeWithMe.Uber.Uber.entities.Rider;
import com.codeWithMe.Uber.Uber.entities.enums.PaymentStatus;
import com.codeWithMe.Uber.Uber.entities.enums.TransactionMethod;
import com.codeWithMe.Uber.Uber.repositories.PaymentRepository;
import com.codeWithMe.Uber.Uber.services.PaymentService;
import com.codeWithMe.Uber.Uber.services.WalletService;
import com.codeWithMe.Uber.Uber.strategies.PaymentStrategy;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//Rider had 232, Driver had 500
//Ride cost is 100 , commission = 30
//Rider -> 232 - 100
//Driver -> 500 + (100 - 30) = 570

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;
    @Override
    @Transactional
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(), payment.getAmount()
        , null, payment.getRide(), TransactionMethod.RIDE);

        double driversCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);

        walletService.addMoneyToWallet(driver.getUser(), driversCut,
                null, payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
