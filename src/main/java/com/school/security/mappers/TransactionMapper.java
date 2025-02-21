package com.school.security.mappers;

import com.school.security.dtos.requests.TransactionReqDto;
import com.school.security.dtos.responses.TransactionResDto;
import com.school.security.entities.Transaction;
import com.school.security.entities.User;
import com.school.security.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class TransactionMapper implements Mapper<TransactionReqDto, Transaction, TransactionResDto> {
    private UserRepository userRepository;

    @Override
    public Transaction fromDto(TransactionReqDto d) {
        if (d.user() == null) {
            throw new IllegalArgumentException("User ID must not be null");
        }
        Transaction transaction = new Transaction();
        Optional<User> userOptional = this.userRepository.findById(d.user());

        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User not found with ID: " + d.user());
        }
        transaction.setDateOfTransaction(d.dateOfTransaction());
        transaction.setTransactionType(d.transactionType());
        transaction.setUser(userOptional.get());
        transaction.setStatus(d.status());
        transaction.setReferences(d.reference());
        transaction.setAmount(d.amount());
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
                entity.getAmount(),
                entity.getStatus()
        );
    }
}
