package com.chamaru.entity;

import jakarta.persistence.*;
import lombok.Data;

// 대여료 엔티티

@Entity
@Table(name = "rental")
@Data
public class Rental extends BaseEntity{

    // 대여료 ID
    @Id
    @GeneratedValue
    @Column(name = "rental_id")
    private Long id;

    // 차량 엔티티와 일대일 매핑
    @OneToOne(fetch = FetchType.LAZY) // 지연 로딩
    @JoinColumn(name = "car_id") // 매핑할 상대의 PK 컬럼을 지정
    private Car car;

    // 1개월 금액
    @Column(name = "rental_fee_1")
    private Long fee1;

    // 3개월 금액
    @Column(name = "rental_fee_2")
    private Long fee2;

    // 6개월 금액
    @Column(name = "rental_fee_3")
    private Long fee3;

    // 12개월 금액
    @Column(name = "rental_fee_4")
    private Long fee41;

    // 24개월 금액
    @Column(name = "rental_fee_5")
    private Long fee5;

    // 36개월 금액
    @Column(name = "rental_fee_6")
    private Long fee6;
}
