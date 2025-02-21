package com.school.security.services.implementations;

import com.school.security.dtos.requests.FundReqDto;
import com.school.security.dtos.responses.FundResDto;
import com.school.security.entities.Fund;
import com.school.security.exceptions.EntityException;
import com.school.security.mappers.FundMapper;
import com.school.security.repositories.FundRepository;
import com.school.security.services.contracts.FundService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class FundServiceImpl implements FundService{

    private FundRepository fundRepository ;
    private FundMapper fundMapper ;

    @Override
    public FundResDto createOrUpdate(FundReqDto toSave) {
        Fund fund = this.fundMapper.fromDto(toSave);
        this.fundRepository.save(fund);
        return this.fundMapper.toDto(fund);
    }

    @Override
    public List<FundResDto> findAll() {
        return this.fundRepository.findAll()
                .stream().map(this.fundMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FundResDto findById(Long aLong) {
        Optional<Fund> fundOptional = this.fundRepository.findById(aLong);
        if (fundOptional.isPresent()) {
            Fund fund = fundOptional.get();
            return this.fundMapper.toDto(fund);
        }else{
            throw new EntityException("Fund not found with id : " + aLong);
        }
    }

    @Override
    public FundResDto deleteById(Long aLong) {
        Optional<Fund> fundOptional = this.fundRepository.findById(aLong);
        if (fundOptional.isPresent()) {
            Fund fundToDelete = fundOptional.get();
            this.fundRepository.deleteById(fundToDelete.getIdFund());
            return this.fundMapper.toDto(fundToDelete);
        }else{
            throw new EntityException("unable to delete : fund not found with id : " + aLong);
        }
    }
}
