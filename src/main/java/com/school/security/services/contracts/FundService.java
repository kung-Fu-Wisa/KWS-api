package com.school.security.services.contracts;

import com.school.security.dtos.requests.FundReqDto;
import com.school.security.dtos.responses.FundResDto;
import com.school.security.entities.Fund;

public interface FundService extends Service<FundReqDto, FundResDto,Long> {
}
