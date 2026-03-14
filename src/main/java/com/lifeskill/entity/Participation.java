package com.lifeskill.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "participations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "password"})
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Activity activity;

    private String fileUrl;

    @Column(columnDefinition = "TEXT")
    private String reviewText;

    // 운동 횟수 (예: 10회)
    private Integer exerciseCount;

    // 운동 세트 수 (예: 3세트)
    private Integer exerciseSets;

    @Builder.Default
    private LocalDateTime submittedAt = LocalDateTime.now();

    @Column(nullable = false)
    @Builder.Default
    private String status = "PENDING";

    @PrePersist
    protected void onCreate() {
        if (submittedAt == null) {
            submittedAt = LocalDateTime.now();
        }
    }
}
