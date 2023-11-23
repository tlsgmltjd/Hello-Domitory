package com.example.hellodomitory.domain.accessLog.entity;

import com.example.hellodomitory.domain.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class AccessLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    private Boolean enter;

    private Boolean late;

    @Column(name = "log_time")
    @UpdateTimestamp
    private LocalDateTime logTime;

    public AccessLog init() {
        this.enter = false;
        this.late = false;
        this.logTime = null;
        return this;
    }
}
