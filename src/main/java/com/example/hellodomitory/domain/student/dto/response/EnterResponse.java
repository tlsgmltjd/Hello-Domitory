package com.example.hellodomitory.domain.student.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnterResponse {
    private String name;
    private Integer grade;
    private Boolean late;
}
