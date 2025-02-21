package com.school.security.mappers;

import com.school.security.dtos.requests.HistoryReqDto;
import com.school.security.dtos.responses.HistoryResDto;
import com.school.security.entities.History;
import org.springframework.stereotype.Component;

@Component
public class HistoryMapper implements Mapper <HistoryReqDto, History, HistoryResDto>{
    @Override
    public History fromDto(HistoryReqDto d) {
        History history = new History();
        history.setTransaction(d.transaction());
        history.setCreatedAt(d.createdAt());
        history.setAmount(d.amount());
        return history;
    }

    @Override
    public HistoryResDto toDto(History entity) {
        return new HistoryResDto(
                entity.getIdHistory(),
                entity.getTransaction().getIdTransaction(),
                entity.getAmount(),
                entity.getCreatedAt()
        );
    }
}
