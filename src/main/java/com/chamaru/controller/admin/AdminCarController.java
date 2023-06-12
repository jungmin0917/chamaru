package com.chamaru.controller.admin;

import com.chamaru.dto.CarDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car")
public class AdminCarController {

    @GetMapping("/insert")
    public String insert() {

        return "car/insert";
    }

    @PostMapping("/insert")
    public String insert(CarDTO carDTO) {

        return "redirect:/car/list";
    }


}
