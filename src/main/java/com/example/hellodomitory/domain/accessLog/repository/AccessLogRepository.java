package com.example.hellodomitory.domain.accessLog.repository;

import com.example.hellodomitory.domain.accessLog.entity.AccessLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessLogRepository extends JpaRepository<AccessLog, Long> {
}
