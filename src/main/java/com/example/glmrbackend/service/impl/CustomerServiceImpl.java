package com.example.glmrbackend.service.impl;

import com.example.glmrbackend.dto.CustomerRegisterRequestDto;
import com.example.glmrbackend.mapper.CustomerMapper;
import com.example.glmrbackend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerMapper customerMapper;
    @Override
    public Boolean saveCustomer(CustomerRegisterRequestDto customerRegisterRequestDto) {
        return null;
    }

}
