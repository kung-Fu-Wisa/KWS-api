package com.school.security.dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FundResDto(
        Long idFund,
        String name,
        BigDecimal amount,
        LocalDateTime createdAt
) {
}
