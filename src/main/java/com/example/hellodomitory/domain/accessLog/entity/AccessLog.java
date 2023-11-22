package com.example.hellodomitory.domain.accessLog.entity;

import com.example.hellodomitory.domain.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class AccessLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    private Boolean enter;

    private Boolean late;

    @Column(name = "log_time")
    private LocalDateTime logTime;
}
