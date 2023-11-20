package com.example.hellodomitory.domain.student.controller;

import com.example.hellodomitory.global.Jwt.JwtUtil;
import com.example.hellodomitory.global.exception.CustomException;
import static com.example.hellodomitory.global.exception.ErrorCode.*;
import com.example.hellodomitory.global.util.MsgResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/student", consumes = "application/json")
@RequiredArgsConstructor
public class StudentController {

    private final JwtUtil jwtUtil;

    @GetMapping("/test")
    public ResponseEntity<MsgResponseDto> test(HttpServletRequest request) {
        String token = jwtUtil.getJwtFromHeader(request);
        if (jwtUtil.validateToken(token)) {
            return ResponseEntity.ok(new MsgResponseDto("성공입니다.", HttpStatus.OK.value()));
        } else {
            throw new CustomException(NOT_OK_TOKEN);
        }

    }
}
