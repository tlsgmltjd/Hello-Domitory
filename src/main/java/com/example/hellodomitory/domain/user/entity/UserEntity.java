package com.example.hellodomitory.domain.user.entity;

import com.example.hellodomitory.domain.accessLog.entity.AccessLog;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "users")
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer grade;
    private Grade gender;
    private Integer timeout;
}

enum Grade {
    FEMALE,
    MALE
}