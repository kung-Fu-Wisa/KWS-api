package com.school.security.dtos.requests;

import com.school.security.entities.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record HistoryReqDto(
        Transaction transaction,
        BigDecimal amount,
        LocalDateTime createdAt
) {
}
