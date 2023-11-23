package com.example.hellodomitory.domain.accessLog.service;

import com.example.hellodomitory.domain.accessLog.entity.AccessLog;
import com.example.hellodomitory.domain.accessLog.repository.AccessLogRepository;
import com.example.hellodomitory.domain.user.entity.UserEntity;
import com.example.hellodomitory.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccessLogService {
    private final AccessLogRepository accessLogRepository;
    private final UserRepository userRepository;

    @Transactional
    public void initAccessLog() {
        Integer savedDate = accessLogRepository.findById(1L).get().getLogTime().getDayOfMonth();
        if (savedDate >= LocalDate.now().getDayOfMonth()) throw new RuntimeException();

        List<AccessLog> accessLogs = accessLogRepository.findAll().stream()
                .map(accessLog -> accessLog.init() ).toList();

        accessLogRepository.saveAll(accessLogs);
    }

}
