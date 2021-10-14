package com.example.glmrbackend.dao.entity;



import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

    String gender;

    LocalDate birthDay;

    String profilePicture;

    String name;

    String phoneNumber;

    String surname;

    String userType;

    String password;


}
