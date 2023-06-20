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
    @Override
    public boolean supports(Class<?> clazz) {
        return JoinForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        JoinForm joinForm = (JoinForm)target;

        /* 1. 아이디 중복 여부
         * 2. 비밀번호, 비밀번호 확인 일치 여부
         * 3. 비밀번호 영문, 숫자, 특수문자 포함하기 확인여부
         * 4. 인증번호 일치여부 확인
         * 5. 이메일 변경여부 확인
         * 6. 휴대전화번호 검증
         * */

        String userId = joinForm.getUserId();
        String userPw = joinForm.getUserPw();
        String userPwRe = joinForm.getUserPwRe();
        String userPhone = joinForm.getUserPhone();
        String userEmail = joinForm.getUserEmail();
        String realEmail = joinForm.getRealEmail();
        String userEmailCheck = joinForm.getUserEmailCheck();
        String codeNum = joinForm.getCodeNum();

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

        //4. 인증번호 일치여부 확인
        System.out.println("내가 적은 인증코드 : " + userEmailCheck);
        System.out.println("메일로 전송된 인증코드 : " + codeNum);
        if (userEmailCheck != null && !userEmailCheck.isBlank() && !userEmailCheck.equals(codeNum)) {
            errors.rejectValue("userEmailCheck", "Incorrect.joinForm.userEmailCheck");
        }

        //5. 이메일 변경여부 확인
        System.out.println("회원가입에 적은 이메일 : " + userEmail);
        System.out.println("최근에 인증한 이메일 : " + realEmail);
        if (!userEmail.equals(realEmail)) {
            errors.rejectValue("userEmail", "Different.joinForm.userEmail");
        }

        //6. 휴대전화번호 검증
        if (userPhone != null && !userPhone.isBlank()) {
            if (!mobileCheck(userPhone)) {
                errors.rejectValue("userPhone", "Validation.userPhone");
            }

            userPhone = userPhone.replaceAll("\\D", "");

            joinForm.setUserPhone(userPhone);

        }
    }
}
