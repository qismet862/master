package com.example.glmrbackend.User.dao.entity;


import com.example.glmrbackend.token.TokenUser;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @NotNull
    String gender;

    String profilePicture;

    @NotNull
    double lat;

        @NotNull
    double lng;

    @NotNull
    String name;

    @NotNull
    String phoneNumber;

    @NotNull
    String surname;

    @NotNull
    String workName;

    String email;

    @NotNull
    LocalDate birthDay;

    int userType;

    @OneToMany(mappedBy = "user")
    private List<TokenUser> tokenUsers;

}
