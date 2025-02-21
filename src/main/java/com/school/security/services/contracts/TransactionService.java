package com.school.security.services.contracts;

import com.school.security.dtos.requests.TransactionReqDto;
import com.school.security.dtos.responses.TransactionResDto;

public interface TransactionService extends Service<TransactionReqDto, TransactionResDto, Long> {
}
