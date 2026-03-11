package com.lifeskill.entity;

import com.lifeskill.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String name;

    private String gender;

    private LocalDate birthDate;

    private String school;

    private Integer grade;

    private Integer classNum;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(nullable = false)
    @Builder.Default
    private String provider = "LOCAL";

    private String kakaoId;

    @Builder.Default
    private boolean profileComplete = false;

    @Column(updatable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}
