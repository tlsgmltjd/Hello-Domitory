package com.example.hellodomitory.domain.accessLog.service;

import com.example.hellodomitory.domain.accessLog.entity.AccessLog;
import com.example.hellodomitory.domain.accessLog.repository.AccessLogRepository;
import com.example.hellodomitory.domain.user.entity.UserEntity;
import com.example.hellodomitory.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccessLogService {
    private final AccessLogRepository accessLogRepository;
    private final UserRepository userRepository;

    public void initAccessLog() {
        List<UserEntity> users = userRepository.findAll();
        List<AccessLog> accessLogs = users.stream().map(user ->
                AccessLog.builder()
                        .enter(false)
                        .late(false)
                        .userId(user)
                        .build()
        ).toList();

        accessLogRepository.saveAll(accessLogs);
    }

}
