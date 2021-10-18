package com.example.glmrbackend.register.controller;


import com.example.glmrbackend.dto.RegisterRequestDto;
import com.example.glmrbackend.dto.RegisterResponseDto;
import com.example.glmrbackend.register.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("http://api.domain.com/user")
public class RegisterController {
    private final RegisterService registerService;
    @PostMapping("/register")
    RegisterResponseDto save(@Valid @RequestBody RegisterRequestDto requestDto){
       return registerService.save(requestDto);

    }
}
