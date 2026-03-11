package com.lifeskill.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {
    private String token;
    private boolean profileComplete;
    private String role;
    private String name;
}
