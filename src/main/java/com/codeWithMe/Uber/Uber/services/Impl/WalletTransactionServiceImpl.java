package com.codeWithMe.Uber.Uber.services.Impl;

import com.codeWithMe.Uber.Uber.dto.WalletTransactionDto;
import com.codeWithMe.Uber.Uber.entities.WalletTransaction;
import com.codeWithMe.Uber.Uber.repositories.WalletTransactionRepository;
import com.codeWithMe.Uber.Uber.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final WalletTransactionRepository walletTransactionRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createNewWalletTransaction(WalletTransaction walletTransaction) {
        walletTransactionRepository.save(walletTransaction);
    }
}
