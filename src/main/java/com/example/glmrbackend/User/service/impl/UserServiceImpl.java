package com.example.glmrbackend.User.service.impl;


import com.example.glmrbackend.User.dao.entity.User;
import com.example.glmrbackend.User.dao.repo.UserRepository;
import com.example.glmrbackend.User.service.UserService;
import com.example.glmrbackend.model.exception.UserExists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public String checkNumber(String number) {
        User customer=userRepository.findByPhoneNumber(number);
        if(customer==null){
            throw new UserExists("Axtardığınız nömrə məlumat bazasında mövcud deyil");
        }
        return null;
    }
}
