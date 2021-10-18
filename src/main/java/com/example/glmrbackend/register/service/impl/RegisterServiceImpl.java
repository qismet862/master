package com.example.glmrbackend.register.service.impl;


import com.example.glmrbackend.mapper.impl.UserMapperImpl;
import com.example.glmrbackend.model.exception.UniqueNumber;
import com.example.glmrbackend.token.TokenUser;
import com.example.glmrbackend.token.TokenUserRepository;
import com.example.glmrbackend.User.dao.entity.User;
import com.example.glmrbackend.User.dao.repo.UserRepository;
import com.example.glmrbackend.dto.RegisterRequestDto;
import com.example.glmrbackend.dto.RegisterResponseDto;
import com.example.glmrbackend.file.FileService;
import com.example.glmrbackend.mapper.UserMapper;
import com.example.glmrbackend.register.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;

    private UserMapperImpl userMapper=new UserMapperImpl();

    private final FileService fileService;

    private final TokenUserRepository tokenUserRepository;

    @Override
    public RegisterResponseDto save(RegisterRequestDto requestDto) {
       User checkUser= userRepository.findByPhoneNumber(requestDto.getPhoneNumber());
       if(checkUser!=null){
           throw new UniqueNumber("Bu nömrə bazada mövcuddur");
       }
        var user = userMapper.requestToEntity(requestDto);
        if (user.getUserType() == 1) {
            if (user.getProfilePicture() != null) {
                try {
                    String fileName = fileService.writeBase64EncodedStringToFile(user.getProfilePicture(), "storage-picture/profilePicture/customer/");
                    user.setProfilePicture(fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            userRepository.save(user);
            User userDB = userRepository.findByPhoneNumber(user.getPhoneNumber());
            String token = generateRandomToken();
            TokenUser tokenUser = new TokenUser();
            tokenUser.setToken(token);
            tokenUser.setUser(userDB);
            tokenUserRepository.save(tokenUser);
        }
        return RegisterResponseDto.builder()
                .resultCode("E200").
                message("Siz uğurla qeydiyyatdan keçdiniz").build();
    }

    public String generateRandomToken() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
