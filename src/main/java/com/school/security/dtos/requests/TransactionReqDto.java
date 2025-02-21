package com.school.security.dtos.requests;

import com.school.security.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionReqDto(
        Long user ,
        LocalDateTime dateOfTransaction ,
        TransactionType transactionType ,
        String reference,
        BigDecimal amount,
        Boolean status
) {
}
