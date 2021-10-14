package com.example.glmrbackend.mapper;

import com.example.glmrbackend.dao.entity.Customer;
import com.example.glmrbackend.dto.CustomerRegisterRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer requestDtoToEntity(CustomerRegisterRequestDto customerRegisterRequestDto);
}
