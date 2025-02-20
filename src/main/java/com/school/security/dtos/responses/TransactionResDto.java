package com.school.security.dtos.responses;

import com.school.security.enums.TransactionType;

import java.sql.Timestamp;

public record TransactionResDto(
        Long userId ,
        Timestamp dateOfTransaction ,
        TransactionType transactionType ,
        String references ,
        Boolean status
) {

}
