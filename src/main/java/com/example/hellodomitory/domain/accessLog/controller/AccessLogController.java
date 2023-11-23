package com.example.hellodomitory.domain.accessLog.controller;

import com.example.hellodomitory.domain.accessLog.dto.request.ResetRequest;
import com.example.hellodomitory.domain.accessLog.service.AccessLogService;
import com.example.hellodomitory.global.util.MsgResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/access")
@RequiredArgsConstructor
public class AccessLogController {
    private final AccessLogService accessLogService;

    @GetMapping("/reset")
    public ResponseEntity<MsgResponseDto> accessLogInit() {
        accessLogService.initAccessLog();
        return ResponseEntity.ok(new MsgResponseDto("초기화 완료", HttpStatus.NO_CONTENT.value()));
    }
}
