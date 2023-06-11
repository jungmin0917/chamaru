package com.chamaru.commons;

import com.chamaru.constant.MemberType;
import com.chamaru.entity.Member;
import com.chamaru.service.member.MemberInfo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberUtils {

    private final HttpSession session;

    public boolean isLogin() {

        return getMember() != null;
    }

    public boolean isAdmin() {

        return isLogin() && getMember().getUserType() == MemberType.ADMIN;
    }

    public MemberInfo getMember() {
        MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");

        return memberInfo;
    }

    public Member getEntity() {
        if (isLogin()) {
            Member member = new ModelMapper().map(getMember(), Member.class);
            return member;
        }

        return null;
    }
}
