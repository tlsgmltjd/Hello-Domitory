package com.example.hellodomitory.domain.user.entity;

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
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer timeout;
}

