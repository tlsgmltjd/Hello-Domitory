package com.example.hellodomitory.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

// 예외 케이스 관리
@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    NOT_MATCH_ADMIN_TOKEN(HttpStatus.BAD_REQUEST, "관리자 암호가 일치하지 않습니다."),
    NOT_OK_TOKEN(HttpStatus.FORBIDDEN, "유효하지 않은 토큰입니다."),
    ALREADY_ENTER(HttpStatus.BAD_REQUEST, "이미 입장했습니다."),
    NOT_FOUND_USER(HttpStatus.BAD_REQUEST, "학생을 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}