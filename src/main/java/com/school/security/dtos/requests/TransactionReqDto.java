package com.school.security.dtos.requests;

import com.school.security.enums.TransactionType;

import java.sql.Timestamp;

public record TransactionReqDto(
        Long idTransaction,
        Long userId ,
        Timestamp dateOfTransaction ,
        TransactionType transactionType ,
        String references ,
        Boolean status
) {
}
