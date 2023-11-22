package com.example.hellodomitory.domain.user.repository;

import com.example.hellodomitory.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
