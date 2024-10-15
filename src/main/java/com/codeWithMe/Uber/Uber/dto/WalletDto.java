package com.codeWithMe.Uber.Uber.dto;

import com.codeWithMe.Uber.Uber.entities.User;
import com.codeWithMe.Uber.Uber.entities.WalletTransaction;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class WalletDto {

    private Long id;

    private UserDto user;

    private Double balance;

    private List<WalletTransactionDto> transactions;
}
