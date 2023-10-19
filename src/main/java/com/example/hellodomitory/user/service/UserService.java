package com.example.hellodomitory.user.service;

import com.example.hellodomitory.global.exception.CustomException;
import com.example.hellodomitory.global.exception.ErrorCode;
import com.example.hellodomitory.user.dto.request.LoginRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Value("${password.key}")
    private String password;

    public void login(LoginRequest request) {
        if (!Objects.equals(request.getPassword(), password)) {
            throw new CustomException(ErrorCode.NOT_MATCH_ADMIN_TOKEN);
        }
    }
}