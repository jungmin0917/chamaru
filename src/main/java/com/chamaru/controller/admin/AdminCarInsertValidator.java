package com.chamaru.controller.admin;

import com.chamaru.constant.CarColor;
import com.chamaru.constant.CarCompany;
import com.chamaru.constant.CarFuel;
import com.chamaru.constant.CarTransmission;
import com.chamaru.dto.CarDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class AdminCarInsertValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CarDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CarDTO carDTO = (CarDTO) target;

        // 검증부분은 추후에 추가
        CarCompany company = carDTO.getCompany();
        String name = carDTO.getName();
        String trim = carDTO.getTrim();
        Long distance = carDTO.getDistance();
        Long displacement = carDTO.getDisplacement();
        CarTransmission transmission = carDTO.getTransmission();
        Integer year1 = carDTO.getYear1();
        Integer month1 = carDTO.getMonth1();
        CarFuel fuel = carDTO.getFuel();
        CarColor color = carDTO.getColor();
        String number = carDTO.getNumber();




    }
}
