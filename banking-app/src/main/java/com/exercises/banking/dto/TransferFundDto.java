package com.exercises.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransferFundDto{
    Long from;
    Long to;
    double amount;
}
