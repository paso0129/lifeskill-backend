package com.lifeskill.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoCompleteRequest {

    private String school;

    @NotNull(message = "Grade is required")
    private Integer grade;

    private Integer classNum;

    @NotBlank(message = "Role is required")
    private String role;
}
