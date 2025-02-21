package com.school.security.dtos.requests;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record HistoryReqDto(
        Long transaction,
        BigDecimal amount,
        BigDecimal totalAmount,
        LocalDateTime createdAt
) {
}
