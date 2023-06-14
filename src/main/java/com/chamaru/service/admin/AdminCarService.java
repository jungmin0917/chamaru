package com.chamaru.service.admin;

import com.chamaru.constant.CarCompany;
import com.chamaru.dto.CarDTO;
import com.chamaru.entity.Car;
import com.chamaru.entity.Member;
import com.chamaru.repository.CarRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminCarService {

    private final CarRepository carRepository;
    public void insert(CarDTO carDTO) {
        // Integer 타입으로 받은 year1(년도) month1(개월) 을 LocalDateTime으로 변환해서 day = 1 로 고정해서 year에 추가
        carDTO.setYear(LocalDateTime.of(carDTO.getYear1(), carDTO.getMonth1(), 1, 0, 0));

        Car car = new ModelMapper().map(carDTO, Car.class);


        carRepository.saveAndFlush(car);
    }
}
