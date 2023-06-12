package com.chamaru.dto;

import com.chamaru.constant.CarColor;
import com.chamaru.constant.CarCompany;
import com.chamaru.constant.CarFuel;
import com.chamaru.constant.CarTransmission;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarDTO {

    // 제조사
    private CarCompany company;

    // 차량 이름
    private String name;

    // 차량 트림
    private String trim;

    // 주행 거리
    private Long distance;

    // 배기량
    private Long displacement;

    // 변속기
    private CarTransmission transmission;

    // 연식
    private LocalDateTime year;

    // 연료 종류
    private CarFuel fuel;

    // 색상
    private CarColor color;

    // 차량번호
    private String number;

    // 썬루프
    private Boolean option1;

    // 전동접이
    private Boolean option2;

    // 열선시트
    private Boolean option3;

    // 통풍시트
    private Boolean option4;

    // 후방카메라
    private Boolean option5;

    // 스마트키
    private Boolean option6;

    // 내비게이션
    private Boolean option7;

    // 하이패스
    private Boolean option8;

    // 블랙박스
    private Boolean option9;

    // 블루투스
    private Boolean option10;
}
