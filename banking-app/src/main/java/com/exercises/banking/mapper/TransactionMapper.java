package com.exercises.banking.mapper;

import com.exercises.banking.dto.TransactionDto;
import com.exercises.banking.entity.Transaction;

public class TransactionMapper {
    public static Transaction mapToTransaction(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setAccountId(transactionDto.getAccountId());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setTransactionType(transactionDto.getTransactionType());
        transaction.setTimestamp(transactionDto.getTimestamp());
        return transaction;
    }

    public static TransactionDto mapToTransactionDto(Transaction transaction) {
        return new TransactionDto(transaction.getAccountId(), transaction.getAmount(), transaction.getTransactionType(), transaction.getTimestamp());
    }
}
