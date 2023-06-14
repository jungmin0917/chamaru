package com.chamaru.dto;

import com.chamaru.constant.CarColor;
import com.chamaru.constant.CarCompany;
import com.chamaru.constant.CarFuel;
import com.chamaru.constant.CarTransmission;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarDTO {

    // 제조사
    @NotNull
    private CarCompany company;

    // 차량 이름
    @NotBlank
    private String name;

    // 차량 등급
    @NotBlank
    private String trim;

    // 주행 거리
    @NotNull
    private Long distance;

    // 배기량
    @NotNull
    private Long displacement;

    // 변속기
    @NotNull
    private CarTransmission transmission;


    // 연식
    private LocalDateTime year;

    // 년도
    @NotNull
    private Integer year1;

    // 개월
    @NotNull
    private Integer month1;

    // 연료 종류
    @NotNull
    private CarFuel fuel;

    // 색상
    @NotNull
    private CarColor color;

    // 차량번호
    @NotBlank
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
