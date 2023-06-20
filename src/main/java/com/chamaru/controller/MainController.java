package com.chamaru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"", "/"})
    public String main() {

        return "front/main";
    }

    @GetMapping("/contract")
    public String contract() {

        return "front/contract";
    }

    @GetMapping("/mypage")
    public String mypage() {

        return "front/mypage";
    }

    @GetMapping("/product")
    public String product() {

        return "front/product";
    }

    @GetMapping("/search")
    public String search() {

        return "front/search";
    }
}
