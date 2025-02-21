package com.school.security.dtos.responses;

import com.school.security.enums.TransactionType;
import java.time.LocalDateTime;

public record TransactionResDto(
        Long idTransaction,
        Long userId ,
        LocalDateTime dateOfTransaction ,
        TransactionType transactionType ,
        String references ,
        Boolean status
) {

}
