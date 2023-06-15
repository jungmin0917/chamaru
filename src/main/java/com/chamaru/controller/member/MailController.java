package com.chamaru.controller.member;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@RequestMapping("/member")
public class MailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping(value="/sendmail", method= RequestMethod.GET)
    @ResponseBody
    public String sendMail(String userEmail) {
        System.out.println(userEmail + "넘어옴");

        /* 인증번호(난수) 생성 */
        Random random = new Random();
        int checkNum = random.nextInt(888888) + 111111;


        /* 이메일 보내기 */
        String setFrom = "chamaru <khs0808sky@gmail.com>";
        String toMail = userEmail;
        String title = "회원가입 인증 이메일 입니다.";
        String content =
                "chamaru홈페이지를 방문해주셔서 감사합니다." +
                        "<br><br>" +
                        "인증 번호는 <b>" + checkNum + "</b> 입니다." +
                        "<br>" +
                        "해당 인증번호를 인증번호란에 기입하여 주세요.";
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8"); // true는 멀티파트 메세지를 사용하겠다는 의미

            /*
             * 단순한 텍스트 메세지만 사용시엔 아래의 코드도 사용 가능
             * MimeMessageHelper mailHelper = new MimeMessageHelper(mail,"UTF-8");
             */

            mailHelper.setFrom(setFrom);
            // 빈에 아이디 설정한 것은 단순히 smtp 인증을 받기 위해 사용 따라서 보내는이(setFrom())반드시 필요
            // 보내는이와 메일주소를 수신하는이가 볼때 모두 표기 되게 원하신다면 아래의 코드를 사용하시면 됩니다.
            //mailHelper.setFrom("보내는이 이름 <보내는이 아이디@도메인주소>");
            mailHelper.setTo(toMail);
            mailHelper.setSubject(title);
            mailHelper.setText(content, true);
            // true는 html을 사용하겠다는 의미입니다.

            /*
             * 단순한 텍스트만 사용하신다면 다음의 코드를 사용하셔도 됩니다. mailHelper.setText(content);
             */

            javaMailSender.send(mail);

        } catch (Exception e) {
            e.printStackTrace();
        }


        String num = Integer.toString(checkNum);
        System.out.println("전달한 번호는 " + num + "입니다.");
        return "[{'param':" + num + "}]";
    }


}
