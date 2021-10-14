package com.example.glmrbackend.service;

import com.example.glmrbackend.dto.CustomerRegisterRequestDto;

public interface CustomerService {
    Boolean saveCustomer(CustomerRegisterRequestDto customerRegisterRequestDto);
}
