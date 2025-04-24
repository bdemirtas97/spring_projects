package com.exercises.banking.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TransactionDto {
    Long accountId;
    double amount;
    String transactionType;
    LocalDateTime timestamp;
}
