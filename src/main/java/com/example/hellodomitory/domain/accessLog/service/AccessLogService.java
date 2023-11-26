package com.example.hellodomitory.domain.accessLog.service;

import com.example.hellodomitory.domain.accessLog.dto.respose.AccessLogsResponse;
import com.example.hellodomitory.domain.accessLog.entity.AccessLog;
import com.example.hellodomitory.domain.accessLog.repository.AccessLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccessLogService {
    private final AccessLogRepository accessLogRepository;

    @Transactional
    public void initAccessLog() {
//        Integer savedDate = accessLogRepository.findById(1L).get().getLogTime().getDayOfMonth();
//        if (savedDate >= LocalDate.now().getDayOfMonth()) throw new RuntimeException();

        List<AccessLog> accessLogs = accessLogRepository.findAll().stream()
                .map(accessLog -> accessLog.init() ).toList();

        accessLogRepository.saveAll(accessLogs);
    }

    @Transactional
    public List<AccessLogsResponse> findAccessLog() {
        return accessLogRepository.findAll().stream()
                .map(accessLog ->
                        AccessLogsResponse.builder()
                                .id(accessLog.getId())
                                .enter(accessLog.getEnter())
                                .late(accessLog.getLate())
                                .name(accessLog.getUserId().getName())
                                .grade(accessLog.getUserId().getGrade())
                                .gender(accessLog.getUserId().getGender())
                                .date(accessLog.getLogTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"))
                        ).build()).toList();
    }

}
