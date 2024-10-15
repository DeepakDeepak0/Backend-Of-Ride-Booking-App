package com.codeWithMe.Uber.Uber.services;

import com.codeWithMe.Uber.Uber.dto.WalletTransactionDto;
import com.codeWithMe.Uber.Uber.entities.WalletTransaction;

public interface WalletTransactionService {

    void createNewWalletTransaction(WalletTransaction walletTransaction);

}
