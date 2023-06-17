package com.chamaru.entity;

import com.chamaru.constant.MemberType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// 회원 엔티티

@Entity
@Table(name = "member")
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Member extends BaseEntity{

    // 회원 고유번호
    @Id @GeneratedValue
    private Long userNo;

    // 회원 아이디
    @Column(length = 20, nullable = false, unique = true) //중복불가 및 널값 불가
    private String userId;

    // 회원 비밀번호
    @Column(length = 65, nullable = false)
    private String userPw;

    // 회원 이름
    @Column(length = 30, nullable = false)
    private String userNm;

    // 회원 이메일
    @Column(nullable = false)
    private String userEmail;

    // 회원 생년월일
    /*@Column(length = 8)
    private LocalDateTime userBirth;*/

    // 전화번호
    @Column(length = 11, nullable = false)
    private String userPhone;

    //주소1
    @Column(nullable = false)
    private String userAddr1;

    //주소2
    @Column(nullable = false)
    private String userAddr2;

    //주소3
    @Column(nullable = false)
    private String userAddr3;

    // 회원 구분
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private MemberType userType = MemberType.USER; //USER - 사용자, ADMIN - 관리자
}
