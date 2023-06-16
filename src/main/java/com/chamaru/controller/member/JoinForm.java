package com.chamaru.controller.member;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class JoinForm {

    @NotBlank
    @Size(min = 8, max = 20)
    private String userId;

    @NotBlank
    @Size(min = 8, max= 20)
    private String userPw;

    @NotBlank
    private String userPwRe;

    @NotBlank
    private String userNm;

    private String codeNum;

    private String realEmail;

    @NotBlank
    @Email
    private String userEmail;

    @NotBlank
    private String userEmailCheck;

    @NotBlank
    private String userPhone;

    @NotBlank
    private String userAddr1;

    @NotBlank
    private String userAddr2;

    @NotBlank
    private String userAddr3;

/*    @AssertTrue
    private boolean agree;*/
}
