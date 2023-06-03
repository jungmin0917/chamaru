package com.chamaru.entity;

import jakarta.persistence.*;
import lombok.Data;

// 관심 엔티티

@Entity
@Table(name = "interest")
@Data
public class Interest extends BaseEntity{

    // 관심 ID
    @Id
    @GeneratedValue
    @Column(name = "interest_id")
    private Long id;

    // 회원 엔티티와 다대일 매핑
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    
    // 차량 엔티티와 다대일 매핑
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
}
