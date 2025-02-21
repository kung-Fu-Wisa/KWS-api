package com.school.security.dtos.requests;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FundReqDto(
        String name,
        BigDecimal amount,
        LocalDateTime createdAt
) {
}
