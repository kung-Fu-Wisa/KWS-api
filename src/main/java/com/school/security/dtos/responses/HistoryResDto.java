package com.school.security.dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record HistoryResDto (
        Long idHistory ,
        Long idTransaction,
        BigDecimal amount,
        LocalDateTime createdAt
){
}
