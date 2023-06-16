package com.chamaru.controller.member;

import com.chamaru.commons.validators.MobileValidator;
import com.chamaru.commons.validators.PasswordValidator;
import com.chamaru.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator, MobileValidator, PasswordValidator {

    private final MemberRepository memberRepository;
    private final MailController mailController;
    @Override
    public boolean supports(Class<?> clazz) {
        return JoinForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        JoinForm joinForm = (JoinForm)target;

        /*1. 아이디 중복 여부
         * 2. 비밀번호, 비밀번호 확인 일치 여부
         * 3. 비밀번호 영문, 숫자, 특수문자 포함하기 확인여부
         * 4. 휴대전화번호 검증*/

        String userId = joinForm.getUserId();
        String userPw = joinForm.getUserPw();
        String userPwRe = joinForm.getUserPwRe();
        String userPhone = joinForm.getUserPhone();
        String userEmail = joinForm.getUserEmail();
        String userEmailCheck = joinForm.getUserEmailCheck();

        //1. 아이디 중복 여부
        if (userId != null && !userId.isBlank() && memberRepository.exists(userId)) {
            errors.rejectValue("userId", "Duplicate.joinForm.userId");
        }

        //2. 비밀번호, 비밀번호 확인 일치 여부
        if (userPw != null && !userPw.isBlank() && userPwRe != null && !userPwRe.isBlank()
                && !userPw.equals(userPwRe)) {
            errors.rejectValue("userPwRe", "Incorrect.joinForm.userPwRe");
        }

        //3. 비밀번호 영문, 숫자, 특수문자 포함하기 확인여부
        if (passwordCheck(userPw)) {
            errors.rejectValue("userPw", "Validation.userPw");
        }

        /*if (mailController.getNum(userEmail) != userEmailCheck) {
            errors.rejectValue("userEmailCheck", "Incorrect.joinForm.userEmailCheck");
        }*/

        //4. 휴대전화번호 검증 (선택사항)
        if (userPhone != null && !userPhone.isBlank()) {
            if (!mobileCheck(userPhone)) {
                errors.rejectValue("userPhone", "Validation.userPhone");
            }

            userPhone = userPhone.replaceAll("\\D", ""); //숫자만 남김
            joinForm.setUserPhone(userPhone);

        }
    }
}
