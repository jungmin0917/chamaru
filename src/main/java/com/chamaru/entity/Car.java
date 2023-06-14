package com.chamaru.entity;

import com.chamaru.constant.CarColor;
import com.chamaru.constant.CarCompany;
import com.chamaru.constant.CarFuel;
import com.chamaru.constant.CarTransmission;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

// 차량 엔티티

@Entity
@Table(name = "car")
@Data
public class Car extends BaseEntity{

    // 차량 ID
    @Id
    @GeneratedValue
    @Column(name = "car_id")
    private Long id;

    // 제조사
    @Column(name = "car_company")
    @Enumerated(EnumType.STRING)
    private CarCompany company;

    // 차량 이름
    @Column(name = "car_name")
    private String name;

    // 차량 트림
    @Column(name = "car_trim")
    private String trim;

    // 주행 거리
    @Column(name = "car_distance")
    private Long distance;

    // 배기량
    @Column(name = "car_displacement")
    private Long displacement;

    // 변속기
    @Column(name = "car_transmission")
    @Enumerated(EnumType.STRING)
    private CarTransmission transmission;
    
    // 연식
    @Column(name = "car_year")
    private LocalDateTime year;
    
    // 연료 종류
    @Column(name = "car_fuel")
    @Enumerated(EnumType.STRING)
    private CarFuel fuel;
    
    // 색상
    @Column(name = "car_color")
    @Enumerated(EnumType.STRING)
    private CarColor color;

    // 차량번호
    @Column(name = "car_number")
    private String number;
    
    // 썬루프
    @Column(name = "car_option_1")
    private Boolean option1;

    // 전동접이
    @Column(name = "car_option_2")
    private Boolean option2;

    // 열선시트
    @Column(name = "car_option_3")
    private Boolean option3;

    // 통풍시트
    @Column(name = "car_option_4")
    private Boolean option4;

    // 후방카메라
    @Column(name = "car_option_5")
    private Boolean option5;

    // 스마트키
    @Column(name = "car_option_6")
    private Boolean option6;

    // 내비게이션
    @Column(name = "car_option_7")
    private Boolean option7;

    // 하이패스
    @Column(name = "car_option_8")
    private Boolean option8;

    // 블랙박스
    @Column(name = "car_option_9")
    private Boolean option9;

    // 블루투스
    @Column(name = "car_option_10")
    private Boolean option10;

    // 조회수
    @Column(name = "car_hit")
    private Long hit;

}








