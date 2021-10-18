package com.example.glmrbackend.mapper.impl;

import com.example.glmrbackend.User.dao.entity.User;
import com.example.glmrbackend.dto.RegisterRequestDto;
import com.example.glmrbackend.mapper.UserMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserMapperImpl implements UserMapper {
    @Override
    public User requestToEntity(RegisterRequestDto registerRequestDto) {
        if (registerRequestDto == null) {
            return null;
        }
        //
        User user = new User();
        user.setGender(registerRequestDto.getGender());
        user.setProfilePicture(registerRequestDto.getProfilePicture());
        user.setLat(registerRequestDto.getLat());
        user.setLng(registerRequestDto.getLng());
        user.setName(registerRequestDto.getName());
        user.setPhoneNumber(registerRequestDto.getPhoneNumber());
        user.setSurname(registerRequestDto.getSurname());
        user.setWorkName(registerRequestDto.getWorkName());
        user.setEmail(registerRequestDto.getEmail());
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("d/MM/yyyy");
        String date=registerRequestDto.getBirthDay();
        LocalDate localDate= LocalDate.parse(date,formatter);
        user.setBirthDay(localDate);
        user.setUserType(registerRequestDto.getUserType());
        return user;
    }
}
