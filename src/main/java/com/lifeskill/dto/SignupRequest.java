package com.lifeskill.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SignupRequest {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Name is required")
    private String name;

    private String gender;

    private LocalDate birthDate;

    private String school;

    @NotNull(message = "Grade is required")
    private Integer grade;

    private Integer classNum;

    @NotBlank(message = "Role is required")
    private String role;
}
