package com.example.glmrbackend.User.controller;

import com.example.glmrbackend.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("http://api.domain.com/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/check/{number}")
    String checkNumber(@PathVariable String number){
        userService.checkNumber(number);
        return null;
    }


}
