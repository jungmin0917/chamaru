package com.chamaru.controller.member;

import com.chamaru.service.member.JoinService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final JoinValidator joinValidator;
    private final JoinService joinService;

    @GetMapping("/join")
    public String join(@ModelAttribute JoinForm joinForm) {

        //return "member/join";
        return "member/joinPage";
    }

    @PostMapping("/join")
    public String joinPost(@Valid JoinForm joinForm, Errors errors) {
        joinValidator.validate(joinForm, errors);


        if (errors.hasErrors()) {
            return "member/joinPage";
        }

        joinService.join(joinForm);

        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm) {


        return "member/login";
    }
}
