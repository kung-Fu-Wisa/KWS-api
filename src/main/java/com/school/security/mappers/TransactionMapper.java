package com.school.security.mappers;

import com.school.security.dtos.requests.TransactionReqDto;
import com.school.security.dtos.responses.TransactionResDto;
import com.school.security.entities.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper implements Mapper<TransactionReqDto, Transaction, TransactionResDto>{
    @Override
    public Transaction fromDto(TransactionReqDto d) {
        Transaction transaction = new Transaction();
        transaction.setDateOfTransaction(d.dateOfTransaction());
        transaction.setTransactionType(d.transactionType());
        transaction.setUser(d.user());
        transaction.setStatus(d.status());
        transaction.setDateOfTransaction(d.dateOfTransaction());
        transaction.setReferences(d.references());
        return transaction;
    }

    @Override
    public TransactionResDto toDto(Transaction entity) {
        return new TransactionResDto(
                entity.getIdTransaction(),
                entity.getUser().getId(),
                entity.getDateOfTransaction(),
                entity.getTransactionType(),
                entity.getReferences(),
                entity.getStatus()
        );
    }
}
