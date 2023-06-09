package com.chamaru.controller.member;

import com.chamaru.commons.validators.MobileValidator;
import com.chamaru.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator, MobileValidator {

    private MemberRepository memberRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return JoinForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        JoinForm joinForm = (JoinForm)target;

        /*1. 아이디 중복 여부
         * 2. 비밀번호, 비밀번호 확인 일치 여부
         * 3. 휴대전화번호 검증*/

        String userId = joinForm.getUserId();
        String userPw = joinForm.getUserPw();
        String userPwRe = joinForm.getUserPwRe();
        String mobile = joinForm.getUserPhone();

        //1. 아이디 중복 여부
        if (userId != null && !userId.isBlank() && memberRepository.exists(userId)) {
            errors.rejectValue("userId", "Duplicate.joinForm.userId");
        }

        //2. 비밀번호, 비밀번호 확인 일치 여부
        if (userPw != null && !userPw.isBlank() && userPwRe != null && !userPwRe.isBlank()
                && !userPw.equals(userPwRe)) {
            errors.rejectValue("userPwRe", "Incorrect.joinForm.userPwRe");
        }

        //3. 휴대전화번호 검증 (선택사항)
        if (mobile != null && !mobile.isBlank()) {
            if (!mobileCheck(mobile)) {
                errors.rejectValue("mobile", "Validation.mobile");
            }

            mobile = mobile.replaceAll("\\D", ""); //숫자만 남김
            joinForm.setUserPhone(mobile);

        }
    }
}
