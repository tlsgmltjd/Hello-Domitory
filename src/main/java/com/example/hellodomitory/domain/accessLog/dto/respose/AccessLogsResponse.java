package com.example.hellodomitory.domain.accessLog.dto.respose;

import com.example.hellodomitory.domain.user.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessLogsResponse {
    private Long id;
    private String name;
    private Integer grade;
    private Gender gender;
    private Boolean enter;
    private Boolean late;
    private String date;
}
