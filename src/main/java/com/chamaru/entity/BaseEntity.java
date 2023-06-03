package com.chamaru.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(value = {AuditingEntityListener.class}) // Auditing 적용
@MappedSuperclass // 공통 멤버변수 매핑을 위한 클래스임을 뜻함
@Data
public class BaseEntity {
    @CreatedDate // 엔티티 생성 시 시간 저장
    @Column(updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate // 엔티티 값 변경 시 시간 저장
    private LocalDateTime updateDate;
}
