package com.chamaru.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@RequestMapping("/member")
public class MailController {

    @RequestMapping(value="/sendmail", method= RequestMethod.GET)
    @ResponseBody
    public String sendMail(String userEmail) {
        System.out.println(userEmail + "넘어옴");

        /* 인증번호(난수) 생성 */
        Random random = new Random();
        int checkNum = random.nextInt(888888) + 111111;

        String num = Integer.toString(checkNum);
        System.out.println("전달한 번호는 " + num + "입니다.");

        return "[{'param':" + num + "}]";
    }


}
