package com.chamaru.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

// 회원 엔티티

@Entity
@Table(name = "member")
@Data
public class Member extends BaseEntity{

    // 회원 ID
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    // 회원 이메일
    @Column(name = "member_email", unique = true)
    private String email;

    // 회원 토큰 (외부 로그인)
    @Column(name = "member_token")
    private String token;

    // 회원 이름
    @Column(name = "member_name")
    private String name;

    // 생년월일
    @Column(name = "member_birthday")
    private LocalDateTime birthday;

    // 전화번호
    @Column(name = "member_phone")
    private String phone;
}
