package com.example.glmrbackend.register.service;

import com.example.glmrbackend.dto.RegisterRequestDto;
import com.example.glmrbackend.dto.RegisterResponseDto;
import org.springframework.http.ResponseEntity;

public interface RegisterService {
    RegisterResponseDto save(RegisterRequestDto requestDto);

}
