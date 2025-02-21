package com.school.security.mappers;

import com.school.security.dtos.requests.FundReqDto;
import com.school.security.dtos.responses.FundResDto;
import com.school.security.entities.Fund;
import org.springframework.stereotype.Component;

@Component
public class FundMapper implements Mapper<FundReqDto, Fund, FundResDto>{
    @Override
    public Fund fromDto(FundReqDto d) {
        Fund fund = new Fund();
        fund.setName(d.name());
        fund.setCreatedAt(d.createdAt());
        fund.setAmount(d.amount());
        return fund;
    }

    @Override
    public FundResDto toDto(Fund entity) {
        return new FundResDto(
                entity.getIdFund(),
                entity.getName(),
                entity.getAmount(),
                entity.getCreatedAt()
        );
    }
}
