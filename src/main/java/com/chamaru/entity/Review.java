package com.chamaru.entity;

import jakarta.persistence.*;
import lombok.Data;

// 리뷰 엔티티

@Entity
@Table(name = "review")
@Data
public class Review extends BaseEntity{

    // 리뷰 ID
    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    // 회원 엔티티와 다대일 매핑
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // 차량 엔티티와 다대일 매핑
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    // 별점
    @Column(name = "review_point")
    private Long point;

    // 차량명
    @Column(name = "review_car_name")
    private String carName;

    // 대여 기간
    @Column(name = "review_period")
    private String period;

    // 리뷰 내용
    @Column(name = "review_content")
    private String content;
}
