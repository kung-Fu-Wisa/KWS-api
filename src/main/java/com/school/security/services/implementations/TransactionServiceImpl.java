package com.school.security.services.implementations;

import com.school.security.dtos.requests.HistoryReqDto;
import com.school.security.dtos.requests.TransactionReqDto;
import com.school.security.dtos.responses.FundResDto;
import com.school.security.dtos.responses.TransactionResDto;
import com.school.security.entities.Fund;
import com.school.security.entities.Transaction;
import com.school.security.exceptions.EntityException;
import com.school.security.mappers.HistoryMapper;
import com.school.security.mappers.TransactionMapper;
import com.school.security.repositories.FundRepository;
import com.school.security.repositories.HistoryRepository;
import com.school.security.repositories.TransactionRepository;
import com.school.security.services.contracts.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private TransactionMapper transactionMapper;
    private TransactionRepository transactionRepository;
    private FundServiceImpl fundService;
    private FundRepository fundRepository;
    private HistoryRepository historyRepository;
    private HistoryMapper historyMapper;

    @Override
    public TransactionResDto createOrUpdate(TransactionReqDto toSave) {
        Transaction transaction = this.transactionMapper.fromDto(toSave);
        Optional<FundResDto> fundOptional = Optional.ofNullable(this.fundService.findById(1L));
        if (fundOptional.isPresent()) {
            FundResDto fundResDto = fundOptional.get();
            BigDecimal amount = fundResDto.amount().add(toSave.amount());
            Fund fund = new Fund(
                    fundResDto.idFund(),
                    fundResDto.name(),
                    amount,
                    fundResDto.createdAt());
            if (transaction.getStatus()) {
                this.fundRepository.save(fund);
            }
            this.transactionRepository.save(transaction);
            HistoryReqDto historyReqDto = new HistoryReqDto(transaction.getIdTransaction(), transaction.getAmount().add(toSave.amount()), fundResDto.amount(), transaction.getDateOfTransaction());
            this.historyRepository.save(this.historyMapper.fromDto(historyReqDto));

        }
        return this.transactionMapper.toDto(transaction);
    }

    @Override
    public List<TransactionResDto> findAll() {
        return this.transactionRepository.findAll()
                .stream().map(this.transactionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionResDto findById(Long aLong) {
        Optional<Transaction> transactionOptional = this.transactionRepository.findById(aLong);
        if (transactionOptional.isPresent()) {
            Transaction transaction = transactionOptional.get();
            return this.transactionMapper.toDto(transaction);
        } else {
            throw new EntityException("Transaction not found with id : " + aLong);
        }
    }

    @Override
    public TransactionResDto deleteById(Long aLong) {
        Optional<Transaction> transactionOptional = this.transactionRepository.findById(aLong);
        if (transactionOptional.isPresent()) {
            Transaction transaction = transactionOptional.get();
            Optional<FundResDto> fundOptional = Optional.ofNullable(this.fundService.findById(1L));
            if (fundOptional.isPresent()) {
                FundResDto fundResDto = fundOptional.get();
                BigDecimal amount = fundResDto.amount().subtract(transaction.getAmount());
                Fund fund = new Fund(
                        fundResDto.idFund(),
                        fundResDto.name(),
                        amount,
                        fundResDto.createdAt());
                this.fundRepository.save(fund);
            }
            this.transactionRepository.deleteById(transaction.getIdTransaction());
            HistoryReqDto historyReqDto = new HistoryReqDto(transaction.getIdTransaction(), transaction.getAmount(), fundOptional.get().amount().subtract(transaction.getAmount()), transaction.getDateOfTransaction());
            this.historyRepository.save(this.historyMapper.fromDto(historyReqDto));
            return this.transactionMapper.toDto(transaction);
        } else {
            throw new EntityException("unable to delete :  transaction not found with id : " + aLong);
        }
    }
}
