package com.chamaru.controller.admin;

import com.chamaru.constant.CarColor;
import com.chamaru.constant.CarCompany;
import com.chamaru.constant.CarFuel;
import com.chamaru.constant.CarTransmission;
import com.chamaru.dto.CarDTO;
import com.chamaru.service.admin.AdminCarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/car")
@RequiredArgsConstructor
public class AdminCarController {

    private final AdminCarInsertValidator adminCarInsertValidator;
    private final AdminCarService adminCarService;

    @GetMapping("/insert")
    public String insert(@ModelAttribute CarDTO carDTO, Model model) {
        List<CarCompany> carCompanyList = Arrays.asList(CarCompany.values());
        model.addAttribute("carCompanyList", carCompanyList);

        List<CarTransmission> carTransmissionList = Arrays.asList(CarTransmission.values());
        model.addAttribute("carTransmissionList", carTransmissionList);

        List<CarFuel> carFuelList = Arrays.asList(CarFuel.values());
        model.addAttribute("carFuelList", carFuelList);

        List<CarColor> carColorList = Arrays.asList(CarColor.values());
        model.addAttribute("carColorList", carColorList);

        List<Integer> years = year();
        List<Integer> months = month();

        model.addAttribute("years", years);
        model.addAttribute("months", months);
        return "car/insert";
    }

    @PostMapping("/insert")
    public String insert(@Valid CarDTO carDTO, Errors errors, Model model) {
        adminCarInsertValidator.validate(carDTO, errors);

        if (errors.hasErrors()) {
            List<CarCompany> carCompanyList = Arrays.asList(CarCompany.values());
            model.addAttribute("carCompanyList", carCompanyList);

            List<CarTransmission> carTransmissionList = Arrays.asList(CarTransmission.values());
            model.addAttribute("carTransmissionList", carTransmissionList);

            List<CarFuel> carFuelList = Arrays.asList(CarFuel.values());
            model.addAttribute("carFuelList", carFuelList);

            List<CarColor> carColorList = Arrays.asList(CarColor.values());
            model.addAttribute("carColorList", carColorList);

            List<Integer> years = year();
            List<Integer> months = month();

            model.addAttribute("years", years);
            model.addAttribute("months", months);
            return "car/insert";
        }



        adminCarService.insert(carDTO);

        return "redirect:/car/list";
    }

    // 연식 데이터를 위한 메서드
    public List<Integer> year() {
        LocalDateTime today = LocalDateTime.now();
        int eYear = today.getYear();
        int sYear = eYear - 20;

        List<Integer> years = new ArrayList<>();

        for (int i = sYear; i <= eYear; i++) {
            int year = i;
            years.add(i);
        }

        return years;
    }

    // 연식 데이터를 위한 메서드
    public List<Integer> month() {


        List<Integer> months = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            int month = i;
            months.add(i);
        }

        return months;
    }


}
