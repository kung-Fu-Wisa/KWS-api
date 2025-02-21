package com.school.security.dtos.requests;

import com.school.security.entities.User;
import com.school.security.enums.TransactionType;
import java.time.LocalDateTime;

public record TransactionReqDto(
        User user ,
        LocalDateTime dateOfTransaction ,
        TransactionType transactionType ,
        String references ,
        Boolean status
) {
}
