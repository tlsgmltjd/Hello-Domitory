package com.example.hellodomitory.user.controller;

import com.example.hellodomitory.global.Jwt.JwtUtil;
import com.example.hellodomitory.global.util.MsgResponseDto;
import com.example.hellodomitory.user.dto.request.LoginRequest;
import com.example.hellodomitory.user.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<MsgResponseDto> login(@RequestBody @Valid LoginRequest loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto);
        response.addHeader(HttpHeaders.AUTHORIZATION, JwtUtil.createToken("기자위"));
        return ResponseEntity.ok((new MsgResponseDto("로그인 완료.", HttpStatus.OK.value())));
    }
}
