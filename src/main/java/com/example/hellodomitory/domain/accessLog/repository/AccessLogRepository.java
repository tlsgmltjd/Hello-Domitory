package com.example.hellodomitory.domain.accessLog.repository;

import com.example.hellodomitory.domain.accessLog.entity.AccessLog;
import com.example.hellodomitory.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccessLogRepository extends JpaRepository<AccessLog, Long> {
    Optional<AccessLog> findByUserId(UserEntity user);
}
