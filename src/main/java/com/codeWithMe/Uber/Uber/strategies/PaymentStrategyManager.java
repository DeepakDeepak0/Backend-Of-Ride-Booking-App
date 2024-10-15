package com.codeWithMe.Uber.Uber.strategies;

import com.codeWithMe.Uber.Uber.entities.enums.PaymentMethod;
import com.codeWithMe.Uber.Uber.strategies.Impl.CashPaymentStrategy;
import com.codeWithMe.Uber.Uber.strategies.Impl.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {

    private final WalletPaymentStrategy walletPaymentStrategy;
    private final CashPaymentStrategy cashPaymentStrategy;

    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod){
         return switch (paymentMethod){
             case CASH -> cashPaymentStrategy;
             case WALLET -> walletPaymentStrategy;
             default -> throw new RuntimeException("Invalid payment method");
         };
    }
}
