package com.lifeskill.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoCompleteRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Birth date is required")
    private String birthDate;

    private String school;

    @NotNull(message = "Grade is required")
    private Integer grade;

    private Integer classNum;

    @NotBlank(message = "Role is required")
    private String role;
}
