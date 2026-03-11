package com.lifeskill.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipationRequest {

    @NotNull(message = "Activity ID is required")
    private Long activityId;

    private String reviewText;
}
