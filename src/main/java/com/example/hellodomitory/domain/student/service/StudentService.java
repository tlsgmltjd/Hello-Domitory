package com.example.hellodomitory.domain.student.service;

import com.example.hellodomitory.domain.accessLog.entity.AccessLog;
import com.example.hellodomitory.domain.accessLog.repository.AccessLogRepository;
import com.example.hellodomitory.domain.student.dto.response.EnterResponse;
import com.example.hellodomitory.domain.user.entity.UserEntity;
import com.example.hellodomitory.domain.user.repository.UserRepository;
import com.example.hellodomitory.global.exception.CustomException;
import com.example.hellodomitory.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDateTime;


@Service
@RequiredArgsConstructor
public class StudentService {
    private final AccessLogRepository accessLogRepository;
    private final UserRepository userRepository;

    @Transactional
    public EnterResponse studentEnter(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER));

        if (accessLogRepository.findByUserId(user).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER)).getEnter()) {
            throw new CustomException(ErrorCode.ALREADY_ENTER);
        }

        AccessLog accessLog = accessLogRepository.findByUserId(user)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER));

        boolean isLate = LocalDateTime.now(ZoneId.of("Asia/Seoul")).toLocalTime().isAfter(LocalTime.of(21, 35));
        accessLog.enter(isLate);
        accessLogRepository.save(accessLog);

        return EnterResponse.builder()
                .grade(user.getGrade())
                .name(user.getName())
                .late(isLate)
                .build();
    }
}
