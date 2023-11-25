package com.example.hellodomitory.domain.student.controller;

import com.example.hellodomitory.domain.student.dto.request.EnterRequest;
import com.example.hellodomitory.domain.student.dto.response.EnterResponse;
import com.example.hellodomitory.domain.student.service.StudentService;
import com.example.hellodomitory.global.Jwt.JwtUtil;
import com.example.hellodomitory.global.exception.CustomException;
import static com.example.hellodomitory.global.exception.ErrorCode.*;

import com.example.hellodomitory.global.exception.ErrorCode;
import com.example.hellodomitory.global.util.MsgResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/student", consumes = "application/json")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final JwtUtil jwtUtil;

    @PostMapping("/enter")
    public ResponseEntity<EnterResponse> enterStudent(HttpServletRequest httpServletRequest, @RequestBody EnterRequest request) {
//        String token = jwtUtil.getJwtFromHeader(httpServletRequest);
//        if (token == null || !jwtUtil.validateToken(token)) throw new CustomException(ErrorCode.NOT_OK_TOKEN);

        return ResponseEntity.ok(studentService.studentEnter(request.getId()));
    }
}