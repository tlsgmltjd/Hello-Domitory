package com.example.hellodomitory.domain.accessLog.controller;

import com.example.hellodomitory.domain.accessLog.service.AccessLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/access")
@RequiredArgsConstructor
public class AccessLogController {
    private final AccessLogService accessLogService;

    @GetMapping("/reset")
    public ResponseEntity<Void> accessLogInit() {
        accessLogService.initAccessLog();
        return ResponseEntity.noContent().build();
    }
}
