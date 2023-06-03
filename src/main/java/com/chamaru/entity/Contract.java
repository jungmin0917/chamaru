package com.chamaru.entity;


import jakarta.persistence.*;
import lombok.Data;

// 계약 엔티티

@Entity
@Table(name = "contract")
@Data
public class Contract extends BaseEntity{

    // 계약 ID
    @Id
    @GeneratedValue
    @Column(name = "contract_id")
    private Long id;

    // 회원 엔티티와 다대일 매핑
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // 차량 엔티티와 다대일 매핑
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    // 계약 기간
    @Column(name = "contract_period")
    private Long period;

    // 개월당 금액
    @Column(name = "contract_fee")
    private Long fee;
}
