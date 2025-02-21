package com.school.security.controllers.api;

import com.school.security.dtos.requests.FundReqDto;
import com.school.security.dtos.responses.FundResDto;
import com.school.security.services.contracts.FundService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funds")
public class FundController {
    private FundService fundService ;

    public FundController(FundService fundService) {
        this.fundService = fundService;
    }
    @GetMapping
    public List<FundResDto> findAll(){
        return this.fundService.findAll();
    }

    @GetMapping("/{id}")
    public FundResDto findById(@PathVariable  Long id){
        return  this.fundService.findById(id);
    }

    @PostMapping("/register")
    public FundResDto register(@RequestBody FundReqDto fund ){
        return  this.fundService.createOrUpdate(fund);
    }

    @DeleteMapping("/{id}")
    public FundResDto delete(@PathVariable Long id){
        return this.fundService.deleteById(id);
    }

}
