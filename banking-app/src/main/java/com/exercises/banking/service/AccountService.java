package com.exercises.banking.service;

import com.exercises.banking.dto.AccountDto;
import com.exercises.banking.dto.TransactionDto;
import com.exercises.banking.dto.TransferFundDto;
import com.exercises.banking.entity.Transaction;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id, double amount);
    AccountDto withdraw(Long id, double amount);
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long id);
    void transferFunds(TransferFundDto transferFundDto);
    List<TransactionDto> getAccountTransactions(Long accountId);
}
