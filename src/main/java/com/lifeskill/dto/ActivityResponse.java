package com.lifeskill.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityResponse {
    private Long id;
    private String name;
    private String description;
    private String targetGrade;
    private String unitLabel;
    private String guideText;
    private String imageUrl;
    private Integer orderNum;
    private String categoryName;
    private String unitName;
}
