package com.example.glmrbackend.mapper;


import com.example.glmrbackend.User.dao.entity.User;
import com.example.glmrbackend.dto.RegisterRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

public interface UserMapper {
    User requestToEntity(RegisterRequestDto registerRequestDto);
}
