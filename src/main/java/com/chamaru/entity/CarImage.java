package com.chamaru.entity;

import jakarta.persistence.*;

public class CarImage {

    // 차량 이미지 ID
    @Id
    @GeneratedValue
    @Column(name = "car_image_id")
    private Long id;

    // 차량 엔티티와 다대일로 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    // 이미지명
    @Column(name = "image_name")
    private String imageName;

    // 원본 이미지명
    @Column(name = "original_image_name")
    private String originalImageName;

    // 이미지 URL 경로
    @Column(name = "image_url")
    private String imageUrl;
}
