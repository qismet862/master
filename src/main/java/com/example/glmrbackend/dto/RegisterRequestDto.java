package com.example.glmrbackend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterRequestDto {

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
    String birthDay;
    int userType;


}
