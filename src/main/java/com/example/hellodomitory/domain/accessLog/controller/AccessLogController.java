package com.example.hellodomitory.domain.accessLog.controller;

import com.example.hellodomitory.domain.accessLog.dto.request.ResetRequest;
import com.example.hellodomitory.domain.accessLog.dto.respose.AccessLogsResponse;
import com.example.hellodomitory.domain.accessLog.service.AccessLogService;
import com.example.hellodomitory.global.Jwt.JwtUtil;
import com.example.hellodomitory.global.exception.CustomException;
import com.example.hellodomitory.global.exception.ErrorCode;
import com.example.hellodomitory.global.util.MsgResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/access", consumes = "application/json")
@RequiredArgsConstructor
public class AccessLogController {
    private final AccessLogService accessLogService;
    private final JwtUtil jwtUtil;

    @GetMapping("/reset")
    public ResponseEntity<MsgResponseDto> accessLogInit(HttpServletRequest request) {
        String token = jwtUtil.getJwtFromHeader(request);
        if (token == null || !jwtUtil.validateToken(token)) throw new CustomException(ErrorCode.NOT_OK_TOKEN);

        accessLogService.initAccessLog();
        return ResponseEntity.ok(new MsgResponseDto("초기화 완료", HttpStatus.NO_CONTENT.value()));
    }

    @GetMapping
    public ResponseEntity<List<AccessLogsResponse>> accessLogFind(HttpServletRequest request) {
        String token = jwtUtil.getJwtFromHeader(request);
        if (token == null || !jwtUtil.validateToken(token)) throw new CustomException(ErrorCode.NOT_OK_TOKEN);

        return ResponseEntity.ok(accessLogService.findAccessLog());
    }
}
