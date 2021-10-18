package com.example.glmrbackend.token;

import com.example.glmrbackend.User.dao.entity.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TokenUser {
    @Id
    private String token;
    @ManyToOne
//    @JoinColumn(name = "User_id")
    private User user;
}
