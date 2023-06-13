package com.chamaru.controller.admin;

import com.chamaru.constant.CarCompany;
import com.chamaru.constant.CarTransmission;
import com.chamaru.dto.CarDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.chamaru.constant.CarCompany.*;

@Controller
@RequestMapping("/car")
public class AdminCarController {

    @GetMapping("/insert")
    public String insert(@ModelAttribute CarDTO carDTO, Model model) {
        List<CarCompany> carCompanyList = Arrays.asList(CarCompany.values());
        model.addAttribute("carCompanyList", carCompanyList);

        List<CarTransmission> carTransmissionList = Arrays.asList(CarTransmission.values());
        model.addAttribute("carTransmissionList", carTransmissionList);
        return "car/insert";
    }

    @PostMapping("/insert")
    public String insert(@Valid CarDTO carDTO, Errors errors) {
        System.out.println(carDTO);

        return "redirect:/car/list";
    }


}
