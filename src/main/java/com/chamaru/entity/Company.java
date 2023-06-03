package com.chamaru.entity;

import jakarta.persistence.*;
import lombok.Data;

// 제조사 엔티티

@Entity
@Table(name = "company")
@Data
public class Company extends BaseEntity{

    // 제조사 ID
    @Id
    @GeneratedValue
    @Column(name = "company_id")
    private Long id;
    
    // 제조사 이름
    @Column(name = "company_name")
    private String name;
}
