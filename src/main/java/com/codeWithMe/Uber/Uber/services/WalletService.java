package com.codeWithMe.Uber.Uber.services;

import com.codeWithMe.Uber.Uber.entities.Ride;
import com.codeWithMe.Uber.Uber.entities.User;
import com.codeWithMe.Uber.Uber.entities.Wallet;
import com.codeWithMe.Uber.Uber.entities.enums.TransactionMethod;

public interface WalletService {

    Wallet addMoneyToWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod);

    Wallet deductMoneyFromWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod);

    void withdrawAllMyMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);

    Wallet findByUser(User user);


}
